package com.logger.application.post

import com.logger.domain.model.markdown.MarkdownRepository
import com.logger.domain.model.post.Post
import com.logger.domain.model.post.PostPreview
import org.springframework.stereotype.Service

@Service
class PostService(
  private val markdownRepository: MarkdownRepository,
) {
  fun getPost(id: String): Post {
    val markdown = markdownRepository.retrieveMarkdown(id)

    return Post.from(markdown)
  }

  fun getPostPreviews(): List<PostPreview> {
    val markdowns = markdownRepository.retrieveAllMarkdowns()

    return markdowns.map { PostPreview.from(it) }
      .sortedByDescending { it.createdAt }
  }
}
