package com.littlefeet

import com.littlefeet.api.models.Error
import com.littlefeet.util.KtLog
import org.springframework.boot.autoconfigure.web.ResourceProperties
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler
import org.springframework.boot.web.reactive.error.ErrorAttributes
import org.springframework.context.ApplicationContext
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.codec.ServerCodecConfigurer
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.server.UnsupportedMediaTypeStatusException
import reactor.core.publisher.Mono
import java.util.concurrent.TimeoutException


@Component
@Order(-2)
class DispatcherExceptionHandler(
  errorAttributes: ErrorAttributes,
  applicationContext: ApplicationContext,
  serverCodecConfigurer: ServerCodecConfigurer
) : AbstractErrorWebExceptionHandler(errorAttributes, ResourceProperties(), applicationContext) {

  companion object : KtLog()

  init {
    super.setMessageReaders(serverCodecConfigurer.readers)
    super.setMessageWriters(serverCodecConfigurer.writers)
  }

  /**
   * エラーが発生した際に呼び出されるメソッド
   */
  override fun getRoutingFunction(errorAttributes: ErrorAttributes?): RouterFunction<ServerResponse> {

    return RouterFunctions.route(RequestPredicates.all(), HandlerFunction {

      when (val ex = getError(it)) {
        // コントローラにマッピングできなかった場合に起きるエラー
        is ResponseStatusException -> serverResponse(
          status = HttpStatus.NOT_FOUND,
          message = "Not Found.",
          request = it,
          ex = ex
        )
        is UnsupportedMediaTypeStatusException -> serverResponse(
          status = HttpStatus.BAD_REQUEST,
          message = "Bad Request.",
          request = it,
          ex = ex
        )
        is TimeoutException -> serverResponse(
          status = HttpStatus.REQUEST_TIMEOUT,
          message = "Time Out.",
          request = it,
          ex = ex
        )
        else -> serverResponse(
          status = HttpStatus.INTERNAL_SERVER_ERROR,
          message = "Internal Server Error.",
          request = it,
          ex = ex
        )
      }
    })
  }

  private fun serverResponse(
    status: HttpStatus,
    message: String,
    request: ServerRequest,
    ex: Throwable
  ): Mono<ServerResponse> =
    ServerResponse.status(status)
      .body(
        BodyInserters.fromObject(
          Error(
            code = status.value(),
            message = message
          )
        )
      )
      .also {
        log.error(ex)
      }
}
