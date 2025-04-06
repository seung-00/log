package com.logger.config

import com.github.benmanes.caffeine.cache.Cache
import com.github.benmanes.caffeine.cache.Caffeine
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit


/**
 * https://github.com/ben-manes/caffeine/wiki
 */
@Configuration
class CaffeineConfig {

  @Bean
  fun caffeineCache(): Cache<String, String> {
    return Caffeine.newBuilder()
      .maximumSize(1000) // 최대 1000개 항목까지 저장
      .expireAfterWrite(10, TimeUnit.MINUTES) // 10분 지나면 자동 만료
      .build()
  }
}
