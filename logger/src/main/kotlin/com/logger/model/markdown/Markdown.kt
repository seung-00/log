package com.logger.model.markdown

import java.io.File
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

data class Markdown(
  val id: String,
  val content: String,
  val source: File,
) {
  val title: String by lazy { parseTitle() }

  val updatedAt: ZonedDateTime by lazy { parseUpdatedAt() }

  private fun parseTitle(): String {
    return content
      .split("\n")
      .firstOrNull { it.startsWith("# ") }
      ?.removePrefix("# ")
      ?: "No Title"
  }

  private fun parseUpdatedAt(): ZonedDateTime {
    val lastUpdated = source.lastModified()

    return ZonedDateTime.ofInstant(Instant.ofEpochMilli(lastUpdated), ZoneId.systemDefault())
  }


  companion object {
    fun isMarkdown(file: File): Boolean {
      return file.extension == "md"
    }

    fun of(path: String): Markdown {
      val file = File(path)

      if (!isMarkdown(file)) {
        throw IllegalArgumentException("Markdown 파일이 아닙니다. (path: $path)") // TODO: exception 개선
      }

      return Markdown(
        id = file.nameWithoutExtension,
        content = file.readText(),
        source = file,
      )
    }

    fun of(path: String, name: String): Markdown {
      val file = File("$path/$name.md")

      if (!isMarkdown(file)) {
        throw IllegalArgumentException("Markdown 파일이 아닙니다. (path: $path)") // TODO: exception 개선
      }

      return Markdown(
        id = file.nameWithoutExtension,
        content = file.readText(),
        source = file,
      )
    }
  }
}
