package com.logger.infrastructure.cache.caffeine

import com.github.benmanes.caffeine.cache.Cache
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.springframework.stereotype.Service

@Service
class CaffeineService(
  val caffeineCache: Cache<String, String>,
) {
  final inline fun <reified T> get(key: String): T? {
    val jsonString = caffeineCache.getIfPresent(key) ?: return null

    if (jsonString.isEmpty()) {
      return null
    }

    return Json.decodeFromString<T>(jsonString)
  }

  final inline fun <reified T> put(key: String, value: T) {
    val jsonString = Json.encodeToString<T>(value)
    caffeineCache.put(key, jsonString)
  }

  fun evict(key: String) {
    caffeineCache.invalidate(key)
  }

  fun clear() {
    caffeineCache.invalidateAll()
  }
}
