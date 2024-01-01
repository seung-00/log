package com.logger.post.domain

import java.io.File

data class PostPreviews(
  val postPreviews: List<PostPreview>,
) {

  fun toList(): List<PostPreview> {
    return postPreviews
  }

  companion object {
    private fun parseMarkdowns(path: String): List<File> {
      val postDirectories = File(path).listFiles() ?: return emptyList()

      return postDirectories
        .filter { isMarkdown(it) }
    }

    private fun isMarkdown(file: File): Boolean {
      return file.extension == "md"
    }

    fun of(path: String): PostPreviews {
      val postNames = parseMarkdowns(path)

      return PostPreviews(
        postPreviews = postNames.map {
          val id = it.nameWithoutExtension

          PostPreview("$path/$id", id, id)
        }
      )
    }
  }
}
