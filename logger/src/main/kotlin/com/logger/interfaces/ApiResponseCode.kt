package com.logger.interfaces

enum class ApiResponseCode(
  val status: Int,
  val code: String,
  val error: Boolean,
  val message: String,
) {

  OK(200, "logger-01", false, "OK"),
  FORBIDDEN(400, "logger-02", true, "Forbidden"),
  INTERNAL_SERVER_ERROR(500, "logger-03", true, "Internal Server Error"),
}
