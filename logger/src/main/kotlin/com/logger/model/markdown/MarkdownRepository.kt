package com.logger.model.markdown

interface MarkdownRepository {
  fun retrieveMarkdown(name: String): Markdown

  fun retrieveAllMarkdowns(): Markdowns
}
