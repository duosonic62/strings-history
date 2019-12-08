package com.littlefeet.stringshistory.domain.service

import com.littlefeet.domain.CommonHeader
import com.littlefeet.domain.entity.Member
import com.littlefeet.domain.exception.UnAuthorizedException
import com.littlefeet.domain.repository.MemberRepository
import com.littlefeet.service.MemberService
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import java.time.LocalDateTime

@ExtendWith(MockKExtension::class)
class MemberServiceTest {

  private lateinit var memberService: MemberService

  @MockK
  private lateinit var memberRepository: MemberRepository

  @RelaxedMockK
  private lateinit var dummyHeader: CommonHeader
  private val dummyMember = Member().apply {
    id = "1"
    uid = "uid"
    name = "name"
    token = "token"
    tokenExpired = LocalDateTime.of(2019, 10, 1, 10, 0, 0)
  }

  @BeforeEach
  fun setUp() {
    memberService = MemberService(memberRepository)
  }

  @Nested
  inner class SearchTest {
    @Test
    fun positive() {
      every { memberRepository.findBy(any()) }.returns(dummyMember)
      val actual = memberService.search(dummyHeader)
      val expected = dummyMember
      Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun negative() {
      every { memberRepository.findBy(any()) }.returns(null)
      assertThrows<UnAuthorizedException> {
        memberService.search(dummyHeader)

      }
    }
  }
}
