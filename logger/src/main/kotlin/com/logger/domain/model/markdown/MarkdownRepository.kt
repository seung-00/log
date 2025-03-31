package com.logger.domain.model.markdown

interface MarkdownRepository {
  fun retrieveMarkdown(name: String): Markdown

  fun retrieveAllMarkdowns(): List<Markdown>
}
