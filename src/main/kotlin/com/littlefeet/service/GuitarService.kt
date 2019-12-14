package com.littlefeet.service

import com.littlefeet.api.models.GuitarInformation
import com.littlefeet.domain.CommonHeader
import com.littlefeet.domain.converter.GuitarConverter
import com.littlefeet.domain.repository.GuitarRepository
import com.littlefeet.domain.service.AuthorizationMemberService
import org.springframework.stereotype.Service

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
}
