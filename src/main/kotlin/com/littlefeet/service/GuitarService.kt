package com.littlefeet.service

import com.littlefeet.api.models.GuitarInformation
import com.littlefeet.api.models.GuitarRegisterParameter
import com.littlefeet.domain.CommonHeader
import com.littlefeet.domain.converter.GuitarConverter
import com.littlefeet.domain.exception.DbException
import com.littlefeet.domain.repository.GuitarRepository
import com.littlefeet.domain.service.AuthorizationMemberService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

/**
 * ギター情報を扱うアプリケーションサービス
 *
 * @property guitarRepository
 * @property authorizationMemberService
 */
@Service
class GuitarService(
  private val guitarRepository: GuitarRepository,
  private val authorizationMemberService: AuthorizationMemberService
) {

  /**
   * 自分のギター情報を全件表示
   *
   * @param commonHeader
   * @return ギター情報一覧
   */
  fun show(
    commonHeader: CommonHeader
  ): List<GuitarInformation> =
    authorizationMemberService.authorizationScope(commonHeader) { member ->
      GuitarConverter.convertGuitarListResponse(
        guitarRepository.findAll(member.id)
      )
    }

  /**
   * 自分のギターを保存
   *
   * @param commonHeader
   * @param guitarRegisterParameter
   * @return 保存したギター情報
   */
  fun create(
    commonHeader: CommonHeader,
    guitarRegisterParameter: GuitarRegisterParameter
  ): HttpStatus =
    authorizationMemberService.authorizationScope(commonHeader) { member ->
      val entity = GuitarConverter.convertRegisterGuitarParameter(guitarRegisterParameter, member)
      if (guitarRepository.put(entity)) HttpStatus.OK else throw DbException("DB ERROR")
    }

}
