package com.logger.post.presentation.dto

import com.logger.post.domain.PostPreview

data class PostPreviewResponse(
  val id: String,
  val title: String,
)

fun PostPreview.toResponse(): PostPreviewResponse {
  return PostPreviewResponse(
    id = this.id,
    title = this.title,
  )
}
