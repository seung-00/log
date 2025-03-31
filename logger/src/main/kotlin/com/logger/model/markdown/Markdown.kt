package com.logger.model.markdown

import java.io.File
import java.nio.file.Files
import java.nio.file.attribute.BasicFileAttributes
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

data class Markdown(
  val id: String,
  val content: String,
  val path: String,
  val title: String,
  val updatedAt: ZonedDateTime,
  val createdAt: ZonedDateTime = ZonedDateTime.now(),
) {

  companion object {
    private fun parseTitle(file: File): String {
      val firstH1 = file.readText()
        .split("\n")
        .firstOrNull { it.startsWith("# ") }
        ?.removePrefix("# ")

      return firstH1 ?: file.nameWithoutExtension
    }

    private fun parseUpdatedAt(file: File): ZonedDateTime {
      val lastUpdated = file.lastModified()

      return ZonedDateTime.ofInstant(Instant.ofEpochMilli(lastUpdated), ZoneId.systemDefault())
    }

    private fun parseCreatedAt(file: File): ZonedDateTime {
      return try {
        val path = file.toPath()
        val attr: BasicFileAttributes = Files.readAttributes(path, BasicFileAttributes::class.java)
        val createdMillis = attr.creationTime().toMillis()

        ZonedDateTime.ofInstant(Instant.ofEpochMilli(createdMillis), ZoneId.systemDefault())
      } catch (e: Exception) {
        parseUpdatedAt(file)
      }
    }

    fun isMarkdown(file: File): Boolean {
      return file.extension == "md"
    }

    fun of(path: String): Markdown {
      val file = File(path)

      require(isMarkdown(file)) {
        "Markdown 파일이 아닙니다. (path: $path)" // TODO: exception 개선
      }

      return Markdown(
        id = file.nameWithoutExtension,
        content = file.readText(),
        path = path,
        title = parseTitle(file),
        updatedAt = parseUpdatedAt(file),
        createdAt = parseCreatedAt(file),
      )
    }

    fun of(path: String, name: String): Markdown {
      val file = File("$path/$name.md")

      require(isMarkdown(file)) {
        "Markdown 파일이 아닙니다. (path: $path)" // TODO: exception 개선
      }

      return Markdown(
        id = file.nameWithoutExtension,
        content = file.readText(),
        path = path,
        title = parseTitle(file),
        updatedAt = parseUpdatedAt(file),
        createdAt = parseCreatedAt(file),
      )
    }
  }
}
