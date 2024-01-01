package com.logger.post.application

import com.logger.post.domain.Post
import com.logger.post.domain.PostPreview
import com.logger.post.domain.PostPreviews
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class PostService(
  @Value("\${blog.post.path}") private val postPath: String
) {
  fun getPost(name: String): Post {
    val post = Post.of(postPath, name)

    return post
  }

  fun getPostPreviews(): List<PostPreview> {
    val postPreviews = PostPreviews.of(postPath)

    return postPreviews.toList()
  }
}
