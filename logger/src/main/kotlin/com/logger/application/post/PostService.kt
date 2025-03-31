package com.logger.application.post

import com.logger.model.markdown.MarkdownRepository
import com.logger.model.post.Post
import com.logger.model.post.PostPreviews
import org.springframework.stereotype.Service

@Service
class PostService(
  private val markdownRepository: MarkdownRepository,
) {
  fun getPost(name: String): Post {
    val markdown = markdownRepository.retrieveMarkdown(name)

    return Post.from(markdown)
  }

  fun getPostPreviews(): PostPreviews {
    val markdowns = markdownRepository.retrieveAllMarkdowns()

    return PostPreviews.from(markdowns)
  }
}
