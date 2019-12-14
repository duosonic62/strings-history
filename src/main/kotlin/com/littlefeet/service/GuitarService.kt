package com.littlefeet.service

import com.littlefeet.api.models.GuitarInformation
import com.littlefeet.domain.CommonHeader
import com.littlefeet.domain.converter.GuitarConverter
import com.littlefeet.domain.exception.UnAuthorizedException
import com.littlefeet.domain.repository.GuitarRepository
import com.littlefeet.domain.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class GuitarService(
  private val guitarRepository: GuitarRepository,
  private val memberRepository: MemberRepository
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
    memberRepository.findBy(commonHeader)?.let { member ->
      GuitarConverter.convertGuitarListResponse(
        guitarRepository.findAll(member.id)
      )
    } ?: throw UnAuthorizedException("")
}
