package com.logger.post.presentation.dto

import com.logger.post.domain.Post

data class PostResponse(
  val id: String,
  val content: String,
)

fun Post.toResponse(): PostResponse {
  return PostResponse(
    id = this.id,
    content = this.content,
  )
}
