package com.logger.post.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class PostPreviewsTest {
  @Test
  fun `post markdown directory`() {
    val POST_PATH = "src/test/resources/post"
    val postPreviews = PostPreviews.of(POST_PATH)

    println(postPreviews)
    assertThat(postPreviews).isNotNull
    assertThat(postPreviews.postPreviews).allSatisfy {
      assertThat(it.path).contains(POST_PATH)
      assertThat(it.id).doesNotContain(".md")
    }
  }
}
