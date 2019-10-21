package com.littlefeet.domain.converter

import com.littlefeet.api.models.MemberInformation
import com.littlefeet.api.models.MemberPostParameter
import com.littlefeet.api.models.MemberPutParameter
import com.littlefeet.domain.entity.Member

object MemberConverter {
  fun convertShowMember(
    member: Member
  ): MemberInformation =
    MemberInformation(
      name = member.name
    )

  fun convertCreateMember(
    memberPostParameter: MemberPostParameter
  ): Member = Member().apply {
    name = memberPostParameter.name
  }

  fun convertUpdateMember(
    memberPutParameter: MemberPutParameter
  ): Member = Member().apply {
    name = memberPutParameter.name
  }
}
