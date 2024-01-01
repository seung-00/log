package com.logger.post.domain

import java.io.File

class Post(
  val id: String,
  val content: String,
) {


  companion object {
    private fun extractFile(path: String, name: String): File = File("$path/$name.md")

    fun of(path: String, name: String): Post {
      val file = extractFile(path, name)

      return Post(
        id = file.nameWithoutExtension,
        content = file.readText(),
      )
    }
  }
}
