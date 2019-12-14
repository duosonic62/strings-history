package com.littlefeet.domain.service

import com.littlefeet.domain.CommonHeader
import com.littlefeet.domain.entity.Member
import com.littlefeet.domain.exception.UnAuthorizedException
import com.littlefeet.domain.repository.MemberRepository
import org.springframework.stereotype.Component

@Component
class AuthorizationMemberService(
  private val memberRepository: MemberRepository
) {
  /**
   * トークン認証を行うスコープを提供する
   *
   * @param T
   * @param commonHeader
   * @param action
   * @return 実行結果
   */
  fun <T> authorizationScope(commonHeader: CommonHeader, action: (member: Member) -> (T)): T {
    val member: Member =
      memberRepository.findBy(commonHeader) ?: throw UnAuthorizedException("authorization error")
    return action.invoke(member)
  }
}
