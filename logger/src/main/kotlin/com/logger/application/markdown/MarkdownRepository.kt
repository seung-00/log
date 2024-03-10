package com.logger.application.markdown

import com.logger.model.markdown.Markdown
import com.logger.model.markdown.Markdowns

interface MarkdownRepository {
  fun retrieveMarkdown(name: String): Markdown

  fun retrieveAllMarkdowns(): Markdowns
}
