package com.littlefeet.domain.service

import com.littlefeet.api.models.MemberInformation
import com.littlefeet.api.models.MemberPostParameter
import com.littlefeet.api.models.MemberPutParameter
import com.littlefeet.domain.CommonHeader
import com.littlefeet.domain.converter.MemberConverter
import com.littlefeet.domain.entity.Member
import com.littlefeet.domain.exception.DbException
import com.littlefeet.domain.repository.MemberDao
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class MemberService(
  val memberDao: MemberDao
) {
  fun showMember(commonHeader: CommonHeader): MemberInformation =
    MemberConverter.convertShowMember(
      memberDao.selectByToken(commonHeader.token)
    )

  fun create(
    commonHeader: CommonHeader,
    memberPostParameter: MemberPostParameter
  ): HttpStatus {
    val insert = memberDao.insert(MemberConverter.convertCreateMember(memberPostParameter))
    return if (insert == 1) HttpStatus.OK
    else throw DbException("DB ERROR")
  }

  fun update(
    commonHeader: CommonHeader,
    memberPutParameter: MemberPutParameter
  ): HttpStatus {
    val update = memberDao.update(MemberConverter.convertUpdateMember(memberPutParameter))
    return if (update == 1) HttpStatus.OK
    else throw DbException("DB ERROR")
  }

  fun delete(
    commonHeader: CommonHeader
  ): HttpStatus {
    val member = searchMember(commonHeader)
    // ソフトデリート(is_deletedをtrue)する
    val delete = memberDao.update(MemberConverter.convertDeleteMember(member))
    return if (delete == 1) HttpStatus.OK
    else throw DbException("DB ERROR")
  }

  fun searchMember(
    commonHeader: CommonHeader
  ): Member = memberDao.selectByToken(commonHeader.token)
}
