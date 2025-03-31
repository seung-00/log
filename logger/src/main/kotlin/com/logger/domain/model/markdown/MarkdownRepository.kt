package com.logger.domain.model.markdown

interface MarkdownRepository {
  fun retrieveMarkdown(id: String): Markdown

  fun retrieveAllMarkdowns(): List<Markdown>
}
