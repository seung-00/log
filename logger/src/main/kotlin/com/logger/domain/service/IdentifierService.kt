package com.logger.domain.service

import java.util.*

object IdentifierService {
  fun encodeIdentifier(raw: String): String {
    return Base64.getUrlEncoder().encodeToString(raw.toByteArray())
  }

  fun decodeIdentifier(id: String): String {
    val bytes = Base64.getUrlDecoder().decode(id)
    return String(bytes, Charsets.UTF_8)
  }
}
