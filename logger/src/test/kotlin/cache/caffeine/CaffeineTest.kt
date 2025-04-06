package cache.caffeine

import com.github.benmanes.caffeine.cache.Caffeine
import com.logger.infrastructure.cache.caffeine.CaffeineService
import kotlinx.serialization.Serializable
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit

class CaffeineTest {

  private val sut: CaffeineService = CaffeineService(
    Caffeine.newBuilder()
      .expireAfterWrite(1, TimeUnit.SECONDS)
      .build()
  )

  @BeforeEach
  fun setUp() {
    sut.clear()
  }

  @Test
  fun `캐시에 값이 저장되고 조회된다`() {
    val dto = MockData("name", 1)
    sut.put("key", MockData("name", 1))

    val result = sut.get<MockData>("key")

    assertThat(result).isEqualTo(dto)
  }

  @Test
  fun `캐시 TTL이 지나면 값이 사라진다`() {
    val dto = MockData("name", 1)
    sut.put("key", dto)

    Thread.sleep(1500) // 1.5초 대기해서 TTL 만료 유도

    val result = sut.get<MockData>("key")

    assertThat(result).isNull()
  }

  @Test
  fun `캐시 evict`() {
    sut.put("key", "value")
    sut.evict("key")

    val result = sut.get<String>("key")

    assertThat(result).isNull()
  }

  @Serializable
  data class MockData(
    val name: String,
    val age: Int
  )
}
