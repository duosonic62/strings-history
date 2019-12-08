package com.littlefeet.controller

import com.littlefeet.api.models.StringInformation
import com.littlefeet.api.models.StringRegisterParameter
import com.littlefeet.domain.CommonHeader
import com.littlefeet.service.StringService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
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

  /**
   * 弦作成コントローラ
   *
   * @param httpHeaders
   * @param stringRegisterParameter
   * @return 作成した弦情報
   */
  @PostMapping
  fun createString(
    @RequestHeader httpHeaders: HttpHeaders,
    @Valid @RequestBody stringRegisterParameter: StringRegisterParameter
  ): StringInformation = stringService.create(CommonHeader.of(httpHeaders), stringRegisterParameter)

  /**
   * 弦更新コントローラ
   *
   * @param httpHeaders
   * @param stringRegisterParameter
   * @return 更新状況
   */
  @PutMapping
  fun updateString(
    @RequestHeader httpHeaders: HttpHeaders,
    @Valid @RequestBody stringRegisterParameter: StringRegisterParameter
  ): HttpStatus = stringService.update(CommonHeader.of(httpHeaders), stringRegisterParameter)

  /**
   * 弦削除コントローラ
   *
   * @param id
   * @param httpHeaders
   * @return 削除状況
   */
  @DeleteMapping("/{id}")
  fun delete(
    @PathVariable id: String,
    @RequestHeader httpHeaders: HttpHeaders
  ): HttpStatus = HttpStatus.OK

  /**
   * 弦情報検索
   *
   * @param httpHeaders
   * @param name
   * @param maker
   * @param thinGage
   * @param thickGage
   * @return 検索結果
   */
  @GetMapping
  fun search(
    @RequestHeader httpHeaders: HttpHeaders,
    @RequestParam("name") name: String? = null,
    @RequestParam("maker") maker: String? = null,
    @RequestParam("thinGage") thinGage: Int? = null,
    @RequestParam("thickGage") thickGage: Int? = null
  ): List<StringInformation> = stringService.search(CommonHeader.of(httpHeaders), name, maker, thinGage, thickGage)
}
