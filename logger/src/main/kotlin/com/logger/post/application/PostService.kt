package com.logger.post.application

import com.logger.post.domain.Post
import com.logger.post.domain.PostPreview
import com.logger.post.domain.PostPreviews
import com.logger.post.infrastructure.config.BlogPostProperties
import org.springframework.stereotype.Service

@Service
class PostService(
  private val postProperties: BlogPostProperties
) {
  fun getPost(name: String): Post {
    val post = Post.of(postProperties.path, name)

    return post
  }

  fun getPostPreviews(): List<PostPreview> {
    val postPreviews = PostPreviews.of(postProperties.path)

    return postPreviews.toList()
  }
}
