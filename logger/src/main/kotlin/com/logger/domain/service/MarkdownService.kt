package com.logger.domain.service

import com.logger.domain.model.markdown.Markdown
import org.springframework.stereotype.Service
import java.io.File

@Service
class MarkdownService {
    fun retrieveMarkdowns(path: String): List<Markdown> {
      val postDirectories = File(path).listFiles() ?: return emptyList()

      val markdowns = postDirectories
        .filter { Markdown.isMarkdown(it) }
        .map { Markdown.of(it.path) }

      return markdowns
    }
}
