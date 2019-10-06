package com.littlefeet.domain.converter

import com.littlefeet.api.models.MemberInformation
import com.littlefeet.domain.entity.Member

object MemberConverter {
  fun convertShowMember(
    member: Member
  ): MemberInformation =
    MemberInformation(
      name = member.name
    )
}
