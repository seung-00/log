package com.logger.domain.markdown

import java.io.File

data class Markdowns(
  val markdowns: List<Markdown>,
) {
  fun toList(): List<Markdown> {
    return markdowns
  }

  companion object {
    fun of(path: String): Markdowns {
      val postDirectories = File(path).listFiles() ?: return Markdowns(emptyList())

      val markdowns = postDirectories
        .filter { Markdown.isMarkdown(it) }
        .map { Markdown.of(it.path) }

      return Markdowns(markdowns)
    }
  }
}
