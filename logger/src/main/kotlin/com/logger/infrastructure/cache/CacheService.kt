package com.logger.infrastructure.cache

import com.logger.infrastructure.cache.caffeine.CaffeineService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CacheService(
  val caffeineService: CaffeineService,
) {

  val logger: Logger = LoggerFactory.getLogger(CacheService::class.java)

  final inline fun <reified T> get(
    cacheInfo: CacheInfo,
    vararg keys: String = arrayOf(),
  ): T? = caffeineService.get<T>(cacheInfo.getKey(keys))

  final inline fun <reified T> get(
    cacheInfo: CacheInfo,
    vararg keys: String = arrayOf(),
    targetMethod: () -> T,
  ): T {
    val cacheResult = caffeineService.get<T>(cacheInfo.getKey(keys))

    if (cacheResult != null) {
      return cacheResult
    }

    return runSet<T>(cacheInfo, keys, targetMethod = targetMethod)
  }

  final inline fun <reified T> runSet(
    cacheInfo: CacheInfo,
    keys: Array<out String>,
    targetMethod: () -> T,
  ): T = runCatching(targetMethod)
    .onSuccess { cached: T ->
      if (cached != null) {
        caffeineService.put<T>(cacheInfo.getKey(keys), cached)
      } else {
        logger.warn("Cache result is null for cacheInfo: ${cacheInfo.name}, keys: ${cacheInfo.getKey(keys)}")
      }
    }.getOrElse {
      logger.error("Error occurred while running target method for cacheInfo: ${cacheInfo.name}, keys: ${cacheInfo.getKey(keys)}", it)
      throw it
    }

  final inline fun delete(
    cacheInfo: CacheInfo,
    vararg keys: String = arrayOf(),
  ) {
    caffeineService.evict(cacheInfo.getKey(keys))
  }
}
