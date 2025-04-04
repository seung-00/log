package com.logger.presentation.post

import com.logger.domain.model.post.Post
import org.springframework.format.annotation.DateTimeFormat
import java.time.ZonedDateTime

internal data class PostResponse(
  val id: String,
  val title: String,
  val content: String,
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  val updatedAt: ZonedDateTime,
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  val createdAt: ZonedDateTime,
) {
  companion object {
    fun from(post: Post): PostResponse {
      return PostResponse(
        id = post.id,
        content = post.content,
        title = post.title,
        updatedAt = post.updatedAt,
        createdAt = post.createdAt,
      )
    }
  }
}
