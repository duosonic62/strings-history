package com.littlefeet.domain.exception

class DbException : Exception {
  constructor(message: String, cause: Exception? = null) : super(message, cause)
}
