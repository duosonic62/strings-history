package com.littlefeet.controller

import com.littlefeet.domain.CommonHeader
import com.littlefeet.domain.service.MemberService
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class MemberController(
  val memberService: MemberService
) {
  @GetMapping
  fun showMember(
    @RequestHeader httpHeaders: HttpHeaders
  ) = memberService.showMember(CommonHeader.of(httpHeaders))
}
