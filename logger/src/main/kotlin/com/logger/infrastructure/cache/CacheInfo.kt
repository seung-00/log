package com.logger.infrastructure.cache

enum class CacheInfo(
  private val keyPrefix: String,
) {
  MOCK("mock::"),
  POST_PREVIEWS("postPreviews::"),
  POST("post::"),
  ;

  fun getKey(s: Array<out String> = emptyArray()): String {
    return String.format("%s|%s", keyPrefix, s.joinToString("|"))
  }
}
