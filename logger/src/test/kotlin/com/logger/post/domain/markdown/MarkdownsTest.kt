package com.logger.post.domain.markdown

import com.logger.model.markdown.Markdowns
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles


@SpringBootTest
@ActiveProfiles("local", "test")
class MarkdownsTest{

  @Value("\${test.post.path}")
  lateinit var postPath: String

  val sut: Markdowns by lazy {
    Markdowns.of("$postPath")
  }

  @Test
  fun `path 로 마크다운 생성`() {
    assertThat(sut.markdowns.size).isEqualTo(2)
  }
}
