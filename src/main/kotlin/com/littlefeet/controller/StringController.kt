package com.littlefeet.controller

import com.littlefeet.api.models.StringInformation
import com.littlefeet.api.models.StringRegisterParameter
import com.littlefeet.domain.CommonHeader
import com.littlefeet.service.StringService
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

/**
 * 弦情報を管理するクラス
 *
 */
@RestController
@RequestMapping("/string")
class StringController(
  private val stringService: StringService
) {

  @PostMapping
  fun createString(
    @RequestHeader httpHeaders: HttpHeaders,
    @Valid @RequestBody stringRegisterParameter: StringRegisterParameter
  ): StringInformation = stringService.create(CommonHeader.of(httpHeaders), stringRegisterParameter)
}
