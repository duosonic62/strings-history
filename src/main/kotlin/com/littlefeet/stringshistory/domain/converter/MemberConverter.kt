package com.littlefeet.stringshistory.domain.converter

import com.littlefeet.stringhistory.domain.entity.Member
import com.littlefeet.stringshistory.api.models.MemberInformation

object MemberConverter {
  fun convertShowMember(
    member: Member
  ): MemberInformation =
    MemberInformation(
      name = member.name
    )
}
