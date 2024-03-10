package com.logger.application.post

import com.logger.model.post.Post
import com.logger.model.post.PostPreview
import com.logger.model.post.PostPreviews
import org.springframework.stereotype.Service

interface PostService {
  fun getPost(name: String): Post

  fun getPostPreviews(): PostPreviews
}
