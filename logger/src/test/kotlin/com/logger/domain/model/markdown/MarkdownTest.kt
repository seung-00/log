package com.logger.domain.model.markdown

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.time.ZonedDateTime


@SpringBootTest
@ActiveProfiles("local", "test")
class MarkdownTest{

  @Value("\${test.post.path}")
  lateinit var postPath: String

  val sut: Markdown by lazy {
    Markdown.of("$postPath/test.md")
  }

  @Test
  fun `path 로 마크다운 생성`() {
    assertThat(sut.parseText()).isNotBlank()
  }

  @Test
  fun `path 와 name 으로 마크다운 생성`() {
    val sut = Markdown.of("$postPath", "test")

    assertThat(sut.parseText()).isNotBlank()
  }

  @Test
  fun `마크다운 title 파싱`() {
    assertThat(sut.parseTitle()).isEqualTo("Title")
  }

  @Test
  fun `마크다운 updatedAt 파싱`() {
    val updatedAt = sut.parseUpdatedAt()

    assertThat(updatedAt).isNotNull()
    assertThat(updatedAt).isInstanceOf(ZonedDateTime::class.java)
  }

  @Test
  fun `마크다운 createdAt 파싱`() {
    val createdAt = sut.parseCreatedAt()

    assertThat(createdAt).isNotNull()
    assertThat(createdAt).isInstanceOf(ZonedDateTime::class.java)
  }

  @Test
  fun `파일 형식이 잘못된 경우`() {
    val exception = assertThrows<IllegalArgumentException> {
      Markdown.of("$postPath/test.txt")
    }

    assertThat(exception.message).isEqualTo("Markdown 파일이 아닙니다. (path: $postPath/test.txt)")
  }

  @Test
  fun `없는 위치인 경우`() {
    val exception = assertThrows<IllegalArgumentException> {
      Markdown.of("$postPath/none.md")
    }
  }
}
