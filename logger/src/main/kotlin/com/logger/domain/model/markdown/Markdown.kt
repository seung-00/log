package com.logger.domain.model.markdown

import java.io.File
import java.nio.file.Files
import java.nio.file.attribute.BasicFileAttributes
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

// TODO: File 에 종속적이므로 로직을 domain service 로 옮기고 Post 만 남길 것
data class Markdown(
  val path: String,
  val source: File,
) {
  fun parseText(): String {
    return source.readText()
  }

  fun parseTitle(): String {
    val firstH1 = source.readText()
      .split("\n")
      .firstOrNull { it.startsWith("# ") }
      ?.removePrefix("# ")

    return firstH1 ?: source.nameWithoutExtension
  }

  fun parseCreatedAt(): ZonedDateTime {
    return try {
      val path = source.toPath()
      val attr: BasicFileAttributes = Files.readAttributes(path, BasicFileAttributes::class.java)
      val createdMillis = attr.creationTime().toMillis()

      ZonedDateTime.ofInstant(Instant.ofEpochMilli(createdMillis), ZoneId.systemDefault())
    } catch (e: Exception) {
      parseUpdatedAt()
    }
  }

  fun parseUpdatedAt(): ZonedDateTime {
    val lastUpdated = source.lastModified()

    return ZonedDateTime.ofInstant(Instant.ofEpochMilli(lastUpdated), ZoneId.systemDefault())
  }

  companion object {
    fun isMarkdown(file: File): Boolean {
      return file.extension == "md"
    }

    fun of(path: String): Markdown {
      val file = File(path)

      require(file.isFile && isMarkdown(file)) {
        "Markdown 파일이 아닙니다. (path: $path)" // TODO: exception 개선
      }

      return Markdown(
        path = path,
        source = file,
      )
    }

    fun of(path: String, name: String): Markdown {
      val file = File("$path/$name.md")

      require(file.isFile && isMarkdown(file)) {
        "Markdown 파일이 아닙니다. (path: $path)" // TODO: exception 개선
      }

      return Markdown(
        path = path,
        source = file,
      )
    }
  }
}
