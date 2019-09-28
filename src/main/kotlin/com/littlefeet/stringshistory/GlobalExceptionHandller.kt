package com.littlefeet.stringshistory

import com.littlefeet.stringshistory.api.models.Error
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
  ): Error {
    log.error(ex)
    return com.littlefeet.stringshistory.api.models.Error(
      code = HttpStatus.INTERNAL_SERVER_ERROR.value(),
      message = "Internal Server Error."
    )
  }
}
