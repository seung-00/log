package com.logger.infrastructure.persistance

import com.logger.model.image.ImageRepository
import com.logger.model.markdown.MarkdownRepository
import com.logger.model.image.Image
import com.logger.model.markdown.Markdown
import com.logger.model.markdown.Markdowns
import org.springframework.stereotype.Repository


@Repository
internal class FileSystemRepository(
  private val fileProperties: FilesProperties,
): ImageRepository, MarkdownRepository {
  override fun retrieveImage(imageId: String): Image {
    val url = "file:${fileProperties.path}/asset/images/$imageId"

    return Image(url)
  }

  override fun retrieveMarkdown(name: String): Markdown {
    return Markdown.of(fileProperties.path, name)
  }

  override fun retrieveAllMarkdowns(): Markdowns {
    return Markdowns.of(fileProperties.path)
  }
}
