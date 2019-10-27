package com.littlefeet.domain.exception

class UnAuthorizedException : Exception {
  constructor(message: String, cause: Exception? = null) : super(message, cause)
}
