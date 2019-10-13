package com.littlefeet.domain.service

import com.littlefeet.api.models.MemberInformation
import com.littlefeet.api.models.MemberPostParameter
import com.littlefeet.domain.CommonHeader
import com.littlefeet.domain.converter.MemberConverter
import com.littlefeet.domain.entity.Member
import com.littlefeet.domain.repository.MemberDao
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class MemberService(
  val memberDao: MemberDao
) {
  fun showMember(commonHeader: CommonHeader): MemberInformation =
    MemberConverter.convertShowMember(
      memberDao.selectByToken(commonHeader.token)
    )

  fun create(
    commonHeader: CommonHeader,
    memberPostParameter: MemberPostParameter
  ): HttpStatus {
    val insert = memberDao.insert(
      Member().apply {
        name = memberPostParameter.name
      }
    )
    return if (insert == 1) HttpStatus.OK
    else HttpStatus.INTERNAL_SERVER_ERROR
  }
}
