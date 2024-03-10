package com.logger.application.post

import com.logger.application.markdown.MarkdownRepository
import com.logger.model.post.Post
import com.logger.model.post.PostPreviews
import org.springframework.stereotype.Service

@Service
internal class PostServiceImpl(
  private val markdownRepository: MarkdownRepository
): PostService {
  override fun getPost(name: String): Post {
    val markdown = markdownRepository.retrieveMarkdown(name)
    return Post.from(markdown)
  }

  override fun getPostPreviews(): PostPreviews {
    val markdowns = markdownRepository.retrieveAllMarkdowns()

    return PostPreviews.from(markdowns)
  }
}
