package com.logger.domain.model.post

import com.logger.domain.model.markdown.Markdown
import com.logger.domain.service.IdentifierService
import java.time.ZonedDateTime

class Post(
  val id: String,
  val title: String,
  val content: String,
  val createdAt: ZonedDateTime,
  val updatedAt: ZonedDateTime,
  val tags: List<String> = emptyList(),
) {
  companion object {
    private fun exceptTitleFromContent(content: String, title: String): String =
      content.replaceFirst(title, "")

    fun from(markdown: Markdown): Post {
      val title = markdown.parseTitle()

      return Post(
        id = IdentifierService.encodeIdentifier(markdown.source.nameWithoutExtension),
        title = title,
        content = exceptTitleFromContent(markdown.parseText(), title),
        createdAt = markdown.parseCreatedAt(),
        updatedAt = markdown.parseUpdatedAt()
      )
    }
  }
}
