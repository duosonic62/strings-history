package com.littlefeet.infrastracture

import com.littlefeet.api.models.MemberPostParameter
import com.littlefeet.api.models.MemberPutParameter
import com.littlefeet.domain.CommonHeader
import com.littlefeet.domain.converter.MemberConverter
import com.littlefeet.domain.entity.Member
import com.littlefeet.domain.repository.MemberDao
import com.littlefeet.domain.repository.MemberRepository
import org.springframework.stereotype.Component

@Component
class DefaultMemberRepository(
  private val memberDao: MemberDao
) : MemberRepository {
  override fun findBy(commonHeader: CommonHeader): Member? =
    memberDao.selectByToken(commonHeader.token)

  override fun put(memberPostParameter: MemberPostParameter): Boolean {
    val member = MemberConverter.convertCreateMemberParameter(memberPostParameter)
    return memberDao.insert(member) == 1
  }

  override fun update(member: Member, memberPutParameter: MemberPutParameter): Boolean =
    memberDao.update(MemberConverter.convertUpdateMemberParameter(memberPutParameter, member)) == 1

  override fun delete(member: Member): Boolean =
    memberDao.update(MemberConverter.convertDeleteMemberParameter(member)) == 1

}
