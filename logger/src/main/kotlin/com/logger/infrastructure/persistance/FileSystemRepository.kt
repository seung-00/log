package com.logger.infrastructure.persistance

import com.logger.domain.model.image.Image
import com.logger.domain.model.image.ImageRepository
import com.logger.domain.model.markdown.Markdown
import com.logger.domain.model.markdown.MarkdownRepository
import com.logger.domain.service.IdentifierService
import com.logger.domain.service.MarkdownService
import org.springframework.stereotype.Repository


@Repository
internal class FileSystemRepository(
  private val fileProperties: FilesProperties,
  private val markdownService: MarkdownService
): ImageRepository, MarkdownRepository {
  override fun retrieveImage(imageId: String): Image {
    val url = "file:${fileProperties.path}/asset/images/$imageId"

    return Image(url)
  }

  override fun retrieveMarkdown(id: String): Markdown {
    val name = IdentifierService.decodeIdentifier(id)

    return Markdown.of(fileProperties.path, name)
  }

  override fun retrieveAllMarkdowns(): List<Markdown> {
    return markdownService.retrieveMarkdowns(fileProperties.path)
  }
}
