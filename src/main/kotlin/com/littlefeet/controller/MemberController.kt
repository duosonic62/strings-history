package com.littlefeet.controller

import com.littlefeet.api.models.MemberPostParameter
import com.littlefeet.domain.CommonHeader
import com.littlefeet.domain.service.MemberService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/member")
class MemberController(
  val memberService: MemberService
) {
  @GetMapping
  fun showMember(
    @RequestHeader httpHeaders: HttpHeaders
  ) = memberService.showMember(CommonHeader.of(httpHeaders))

  @PostMapping
  fun createMembere(
    @RequestHeader httpHeaders: HttpHeaders,
    @Valid @RequestBody memberPostParameter: MemberPostParameter
  ): HttpStatus = memberService.create(CommonHeader.of(httpHeaders), memberPostParameter)
}

