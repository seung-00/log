package com.logger.presentation.post

import com.logger.application.post.PostService
import com.logger.presentation.common.ApiResponse
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = arrayOf("*"))
internal class PostController(
  private val postService: PostService,
) {
  @GetMapping("/api/v1/posts/{id}")
  fun getPost(
    @PathVariable id: String,
  ): ApiResponse<PostResponse> {
    val result = postService.getPost(id)

    return ApiResponse.ok(PostResponse.from(result))
  }

  @GetMapping("/api/v1/posts/previews")
  fun getPostPreviews(): ApiResponse<List<PostPreviewResponse>> {
    val result = postService.getPostPreviews()

    return ApiResponse.ok(
      result.toList().map {
        PostPreviewResponse.from(it)
      }
    )
  }
}
