package cache

import com.github.benmanes.caffeine.cache.Caffeine
import com.logger.infrastructure.cache.CacheInfo
import com.logger.infrastructure.cache.CacheService
import com.logger.infrastructure.cache.caffeine.CaffeineService
import kotlinx.serialization.Serializable
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit

class CacheServiceTest {

  private val caffeineService: CaffeineService = CaffeineService(
    Caffeine.newBuilder()
      .expireAfterWrite(1, TimeUnit.SECONDS)
      .build()
  )

  @Serializable
  data class MockData(
    val name: String,
    val age: Int,
  )

  private lateinit var diskMock: Map<String, MockData>

  private val sut: CacheService = CacheService(caffeineService)


  @BeforeEach
  fun setUp() {
    caffeineService.clear()
    diskMock = emptyMap()
  }

  @Test
  fun `캐시에 값이 저장되고 조회된다`() {
    val dto = MockData("name", 1)

    sut.runSet(
      cacheInfo = CacheInfo.MOCK,
      keys = arrayOf("key"),
    ) {
      diskMock.plus("key" to dto)["key"]
    }

    val result = sut.get<MockData>(
      cacheInfo = CacheInfo.MOCK,
      keys = arrayOf("key")
    )

    assertThat(result).isEqualTo(dto)
  }

  @Test
  fun `캐시 TTL이 지나면 값이 사라진다`() {
    val dto = MockData("name", 1)

    sut.runSet(
      cacheInfo = CacheInfo.MOCK,
      keys = arrayOf("key"),
    ) {
      diskMock.plus("key" to dto)["key"]
    }

    Thread.sleep(1500) // 1.5초 대기해서 TTL 만료 유도

    val result = sut.get<MockData>(
      cacheInfo = CacheInfo.MOCK,
      keys = arrayOf("key")
    )

    assertThat(result).isNull()
  }

  @Test
  fun `캐시 evict`() {
    val dto = MockData("name", 1)

    sut.runSet(
      cacheInfo = CacheInfo.MOCK,
      keys = arrayOf("key"),
    ) {
      diskMock.plus("key" to dto)["key"]
    }

    sut.delete(
      cacheInfo = CacheInfo.MOCK,
      keys = arrayOf("key")
    )

    val result = sut.get<String>(
      cacheInfo = CacheInfo.MOCK,
      keys = arrayOf("key")
    )

    assertThat(result).isNull()
  }
}
