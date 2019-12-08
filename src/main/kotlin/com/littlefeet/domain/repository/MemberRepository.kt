package com.littlefeet.domain.repository

import com.littlefeet.api.models.MemberPostParameter
import com.littlefeet.api.models.MemberPutParameter
import com.littlefeet.domain.CommonHeader
import com.littlefeet.domain.entity.Member
import org.springframework.stereotype.Repository

/**
 * メンバーに関する永続化の責務を果たすインターフェース
 *
 */
@Repository
interface MemberRepository {
  fun findBy(commonHeader: CommonHeader): Member?

  fun put(memberPostParameter: MemberPostParameter): Boolean

  fun update(member: Member, memberPutParameter: MemberPutParameter): Boolean

  fun delete(member: Member): Boolean
}
