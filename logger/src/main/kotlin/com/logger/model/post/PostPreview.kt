package com.logger.model.post

import com.logger.model.markdown.Markdown
import java.time.ZonedDateTime

data class PostPreview(
  val id: String,
  val title: String,
  val createdAt: ZonedDateTime
) {
  companion object {
    fun from(markdown: Markdown): PostPreview {
      return PostPreview(
        id = markdown.id,
        title = markdown.title,
        createdAt = markdown.createdAt,
      )
    }
  }
}
