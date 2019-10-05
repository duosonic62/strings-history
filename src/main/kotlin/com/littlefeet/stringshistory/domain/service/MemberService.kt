package com.littlefeet.stringshistory.domain.service

import com.littlefeet.stringhistory.domain.repository.MemberDao
import com.littlefeet.stringshistory.api.models.MemberInformation
import com.littlefeet.stringshistory.domain.CommonHeader
import com.littlefeet.stringshistory.domain.converter.MemberConverter
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
