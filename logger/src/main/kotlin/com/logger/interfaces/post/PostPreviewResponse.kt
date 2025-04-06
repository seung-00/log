package com.logger.interfaces.post

import com.logger.domain.model.SEOUL_ZONE_ID
import com.logger.domain.model.post.PostPreview
import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.time.ZonedDateTime

internal data class PostPreviewResponse(
  val id: String,
  val title: String,
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  val createdAt: ZonedDateTime,
) {
  companion object {
    fun from(postPreview: PostPreview): PostPreviewResponse {
      return PostPreviewResponse(
        id = postPreview.id,
        title = postPreview.title,
        createdAt = ZonedDateTime.ofInstant(Instant.ofEpochMilli(postPreview.createdAt), SEOUL_ZONE_ID),
      )
    }
  }
}
