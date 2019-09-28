package com.littlefeet.stringshistory

import com.littlefeet.stringshistory.util.KtLog
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandller {
  companion object : KtLog()

  @ExceptionHandler(Exception::class)
  fun handleException(
    ex: java.lang.Exception
  ): HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR
}
