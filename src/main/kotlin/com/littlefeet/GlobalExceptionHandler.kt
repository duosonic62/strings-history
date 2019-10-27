package com.littlefeet

import com.littlefeet.api.models.Error
import com.littlefeet.domain.exception.DbException
import com.littlefeet.domain.exception.NotFoundException
import com.littlefeet.util.KtLog
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
  companion object : KtLog()

  /**
   * DBエラーをINTERNAL SERVER ERRORにハンドリングする
   *
   * @param ex Exception
   * @return
   */
  @ExceptionHandler(DbException::class)
  fun handleDbException(
    ex: DbException
  ): Error {
    log.error(ex)
    return com.littlefeet.api.models.Error(
      code = HttpStatus.INTERNAL_SERVER_ERROR.value(),
      message = ex.message
    )
  }

  /**
   * 該当のデータが見つからないエラーをNOT FOUNDにハンドリングする
   *
   * @param ex Exception
   * @return
   */
  @ExceptionHandler(NotFoundException::class)
  fun handleNotFoundException(
    ex: NotFoundException
  ): Error {
    log.error(ex)
    return com.littlefeet.api.models.Error(
      code = HttpStatus.NOT_FOUND.value(),
      message = ex.message
    )
  }

  @ExceptionHandler(Exception::class)
  fun handleException(
    ex: java.lang.Exception
  ): Error {
    log.error(ex)
    return Error(
      code = HttpStatus.INTERNAL_SERVER_ERROR.value(),
      message = "Internal Server Error."
    )
  }
}
