package com.littlefeet.domain

import org.springframework.http.HttpHeaders

/**
 * 共通ヘッダー
 */
class CommonHeader private constructor(
  val token: String
) {
  companion object {
    // TODO ERROR HANDLING
    fun of(httpHeaders: HttpHeaders): CommonHeader =
      httpHeaders.getFirst("Authorization")?.let {
        CommonHeader(it.replace("Bearer ", ""))
      } ?: throw Exception("authorization error")
  }
}
