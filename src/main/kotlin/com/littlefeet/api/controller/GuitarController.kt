package com.littlefeet.api.controller

import com.littlefeet.api.models.GuitarInformation
import com.littlefeet.api.models.GuitarRegisterParameter
import com.littlefeet.domain.CommonHeader
import com.littlefeet.service.GuitarService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

/**
 * ギター情報に関するコントローラ
 *
 * @property guitarService
 */
@RestController
@RequestMapping("/guitar")
class GuitarController(
  private val guitarService: GuitarService
) {
  /**
   * ギター情報取得
   *
   * @param httpHeaders
   * @return ギター情報
   */
  @GetMapping
  fun show(
    @RequestHeader httpHeaders: HttpHeaders
  ): List<GuitarInformation> = guitarService.show(CommonHeader.of(httpHeaders))

  /**
   * ギター情報作成
   *
   * @param httpHeaders
   * @param guitarRegisterParameter
   */
  @PostMapping
  fun create(
    @RequestHeader httpHeaders: HttpHeaders,
    @Valid @RequestBody guitarRegisterParameter: GuitarRegisterParameter
  ): HttpStatus = guitarService.create(CommonHeader.of(httpHeaders), guitarRegisterParameter)
}
