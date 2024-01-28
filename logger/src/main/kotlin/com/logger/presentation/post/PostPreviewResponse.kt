package com.logger.presentation.post

import com.logger.domain.post.PostPreview
import org.springframework.format.annotation.DateTimeFormat
import java.time.ZonedDateTime

internal data class PostPreviewResponse(
  val id: String,
  val title: String,
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  val updatedAt: ZonedDateTime,
) {
  companion object {
    fun from(postPreview: PostPreview): PostPreviewResponse {
      return PostPreviewResponse(
        id = postPreview.id,
        title = postPreview.title,
        updatedAt = postPreview.updatedAt,
      )
    }
  }
}
