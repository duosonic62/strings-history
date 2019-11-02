package com.littlefeet.stringshistory.domain.converter

import com.littlefeet.api.models.MemberInformation
import com.littlefeet.domain.converter.MemberConverter
import com.littlefeet.domain.entity.Member
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class MemberConverterTest {
  companion object {
    private const val DUMMY_MEMBER_NAME = "test user"
  }

  @Nested
  inner class ConvertShowMemberResponseTest {

    @Test
    fun positive() {
      val response = Member().apply { name = DUMMY_MEMBER_NAME }
      val actual = MemberConverter.convertShowMemberResponse(response)
      val expected = MemberInformation(name = DUMMY_MEMBER_NAME)
      Assertions.assertThat(actual).isEqualTo(expected)
    }
  }
}
