package com.littlefeet.api.controller

import com.littlefeet.api.models.GuitarInformation
import com.littlefeet.domain.CommonHeader
import com.littlefeet.service.GuitarService
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/guitar")
class GuitarController(
  private val guitarService: GuitarService
) {
  @GetMapping
  fun show(
    @RequestHeader httpHeaders: HttpHeaders
  ): List<GuitarInformation> = guitarService.show(CommonHeader.of(httpHeaders))
}
