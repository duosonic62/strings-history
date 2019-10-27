package com.littlefeet.controller

import com.littlefeet.api.models.MemberPostParameter
import com.littlefeet.api.models.MemberPutParameter
import com.littlefeet.domain.CommonHeader
import com.littlefeet.domain.service.MemberService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

/**
 * 会員情報を管理するコントローラ
 *
 * @property memberService
 */
@RestController
@RequestMapping("/member")
class MemberController(
  val memberService: MemberService
) {
  /**
   * 会員情報を取得
   *
   * @param httpHeaders
   */
  @GetMapping
  fun showMember(
    @RequestHeader httpHeaders: HttpHeaders
  ) = memberService.show(CommonHeader.of(httpHeaders))

  /**
   * 会員情報を作成
   *
   * @param httpHeaders
   * @param memberPostParameter
   * @return
   */
  @PostMapping
  fun createMember(
    @RequestHeader httpHeaders: HttpHeaders,
    @Valid @RequestBody memberPostParameter: MemberPostParameter
  ): HttpStatus = memberService.create(CommonHeader.of(httpHeaders), memberPostParameter)

  /**
   * 会員情報を更新
   *
   * @param httpHeaders
   * @param memberPutParameter
   * @return
   */
  @PutMapping
  fun updateMember(
    @RequestHeader httpHeaders: HttpHeaders,
    @Valid @RequestBody memberPutParameter: MemberPutParameter
  ): HttpStatus = memberService.update(CommonHeader.of(httpHeaders), memberPutParameter)

  /**
   * 会員情報を削除
   *
   * @param httpHeaders
   * @return
   */
  @DeleteMapping
  fun deleteMember(
    @RequestHeader httpHeaders: HttpHeaders
  ): HttpStatus = memberService.delete(CommonHeader.of(httpHeaders))
}

