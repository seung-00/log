package com.logger.domain.model.post

import com.logger.domain.model.markdown.Markdown
import com.logger.domain.service.IdentifierService
import java.time.ZonedDateTime

data class PostPreview(
  val id: String,
  val title: String,
  val createdAt: ZonedDateTime,
) {
  companion object {
    fun from(markdown: Markdown): PostPreview {
      return PostPreview(
        id = IdentifierService.encodeIdentifier(markdown.source.nameWithoutExtension),
        title = markdown.parseTitle(),
        createdAt = markdown.parseCreatedAt(),
      )
    }
  }
}
