package com.logger.post.presentation

import com.logger.common.presentation.ApiResponse
import com.logger.post.application.PostService
import com.logger.post.presentation.dto.PostPreviewResponse
import com.logger.post.presentation.dto.PostResponse
import com.logger.post.presentation.dto.toResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PostController(
  private val postService: PostService
) {
  @GetMapping("/api/v1/posts/{id}")
  fun getPost(
    @PathVariable id: String
  ): ApiResponse<PostResponse> {
    val result = postService.getPost(id)

    return ApiResponse.ok(result.toResponse())
  }

  @GetMapping("/api/v1/posts/previews")
  fun getPostPreviews(): ApiResponse<List<PostPreviewResponse>> {
    val result = postService.getPostPreviews()

    return ApiResponse.ok(result.map { it.toResponse() })
  }
}
