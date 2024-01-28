package com.logger.application.post

import com.logger.domain.markdown.Markdown
import com.logger.domain.markdown.Markdowns
import com.logger.domain.post.Post
import com.logger.domain.post.PostPreview
import com.logger.domain.post.PostPreviews
import com.logger.infrastructure.config.BlogPostProperties
import org.springframework.stereotype.Service

@Service
internal class PostServiceImpl(
  private val postProperties: BlogPostProperties
): PostService {
  override fun getPost(name: String): Post {
    val markdown = Markdown.of(postProperties.path, name)
    val post = Post.from(markdown)

    return post
  }

  override fun getPostPreviews(): List<PostPreview> {
    val markdowns = Markdowns.of(postProperties.path)
    val postPreviews = PostPreviews.from(markdowns)

    return postPreviews.toList()
  }
}
