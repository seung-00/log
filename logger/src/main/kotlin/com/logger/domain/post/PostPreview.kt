package com.logger.domain.post

import com.logger.domain.markdown.Markdown
import java.time.ZonedDateTime

data class PostPreview(
  val id: String,
  val title: String,
  val updatedAt: ZonedDateTime
) {
  companion object {
    fun from(markdown: Markdown): PostPreview {
      return PostPreview(
        id = markdown.id,
        title = markdown.title,
        updatedAt = markdown.updatedAt,
      )
    }
  }
}
