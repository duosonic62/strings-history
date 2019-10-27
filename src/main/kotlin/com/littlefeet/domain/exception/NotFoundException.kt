package com.littlefeet.domain.exception

class NotFoundException : Exception {
  constructor(message: String, cause: Exception? = null) : super(message, cause)
}
