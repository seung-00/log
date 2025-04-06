package com.logger.application.post

import com.logger.domain.model.markdown.MarkdownRepository
import com.logger.domain.model.post.Post
import com.logger.domain.model.post.PostPreview
import com.logger.infrastructure.cache.CacheInfo
import com.logger.infrastructure.cache.CacheService
import org.springframework.stereotype.Service

@Service
class PostService(
  private val markdownRepository: MarkdownRepository,
  private val cacheService: CacheService,
) {
  fun getPost(id: String): Post {
    return cacheService.get<Post>(CacheInfo.POST, id) {
      Post.from(markdownRepository.retrieveMarkdown(id))
    }
  }

  fun getPostPreviews(): List<PostPreview> {
    return cacheService.get<List<PostPreview>>(CacheInfo.POST_PREVIEWS) {
      markdownRepository.retrieveAllMarkdowns()
        .map { PostPreview.from(it) }
        .sortedByDescending { it.createdAt }
    }
  }
}
