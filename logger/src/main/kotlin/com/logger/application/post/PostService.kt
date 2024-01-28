package com.logger.application.post

import com.logger.domain.post.Post
import com.logger.domain.post.PostPreview

interface PostService {
  fun getPost(name: String): Post

  fun getPostPreviews(): List<PostPreview>
}
