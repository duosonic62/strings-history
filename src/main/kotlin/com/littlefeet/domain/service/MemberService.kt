package com.littlefeet.domain.service

import com.littlefeet.api.models.MemberInformation
import com.littlefeet.domain.CommonHeader
import com.littlefeet.domain.converter.MemberConverter
import com.littlefeet.domain.repository.MemberDao
import org.springframework.stereotype.Service

@Service
class MemberService(
  val memberDao: MemberDao
) {
  fun showMember(commonHeader: CommonHeader): MemberInformation =
    MemberConverter.convertShowMember(
      memberDao.selectByToken(commonHeader.token)
    )
}
