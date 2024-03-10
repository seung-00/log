package com.logger.model.post

import com.logger.model.markdown.Markdowns

data class PostPreviews(
  val postPreviews: List<PostPreview>,
) {

  fun toList(): List<PostPreview> {
    return postPreviews
  }

  companion object {
    fun from(markdowns: Markdowns): PostPreviews {
      return PostPreviews(
        postPreviews = markdowns.toList()
          .map { PostPreview.from(it) }
      )
    }
  }
}
