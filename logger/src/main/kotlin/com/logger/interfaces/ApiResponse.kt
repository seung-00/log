package com.logger.interfaces

data class ApiResponse<T>(
  val code: String,
  val message: String,
  val data: T?,
) {
  companion object {
    fun <T> ok(data: T? = null): ApiResponse<T> {
      return ApiResponse(ApiResponseCode.OK.code, ApiResponseCode.OK.message, data)
    }

    fun <T> error(code: ApiResponseCode, error: String = code.message): ApiResponse<T> {
      return ApiResponse(code.code, error, null)
    }
  }
}
