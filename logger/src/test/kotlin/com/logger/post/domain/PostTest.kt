package com.logger.post.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class PostTest {
  @Test
  fun `post`() {
    val POST_PATH = "src/test/resources/post"
    val POST_NAME = "test"

    val post = Post.of(POST_PATH, POST_NAME)

    assertThat(post.id).isEqualTo(POST_NAME)
    assertThat(post.content).isInstanceOf(String::class.java)
  }
}
