package com.logger.domain.post

import com.logger.domain.markdown.Markdown
import java.time.ZonedDateTime

class Post(
  val id: String,
  val title: String,
  val content: String,
  val updatedAt: ZonedDateTime
) {
  companion object {
    fun from(markdown: Markdown): Post {
      return Post(
        id = markdown.id,
        title = markdown.title,
        content = markdown.content,
        updatedAt = markdown.updatedAt
      )
    }
  }
}
