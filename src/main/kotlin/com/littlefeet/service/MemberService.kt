package com.littlefeet.service

import com.littlefeet.api.models.MemberInformation
import com.littlefeet.api.models.MemberPostParameter
import com.littlefeet.api.models.MemberPutParameter
import com.littlefeet.domain.CommonHeader
import com.littlefeet.domain.converter.MemberConverter
import com.littlefeet.domain.entity.Member
import com.littlefeet.domain.exception.DbException
import com.littlefeet.domain.exception.UnAuthorizedException
import com.littlefeet.domain.repository.MemberRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

/**
 * 会員情報を管理するサービス
 *
 * @property memberDao
 */
@Service
class MemberService(
  private val memberRepository: MemberRepository
) {
  /**
   * 会員情報を表示
   *
   * @param commonHeader
   * @return アプリで表示する会員情報
   */
  fun show(commonHeader: CommonHeader): MemberInformation =
    MemberConverter.convertShowMemberResponse(
      search(commonHeader)
    )

  /**
   * 会員情報を作成
   *
   * @param commonHeader
   * @param memberPostParameter
   * @return 作成ステータス(200 or Error)
   */
  fun create(
    commonHeader: CommonHeader,
    memberPostParameter: MemberPostParameter
  ): HttpStatus =
    if (memberRepository.put(memberPostParameter)) {
      HttpStatus.OK
    } else {
      throw DbException("Can't save member information.")
    }

  /**
   * 会員情報を更新
   *
   * @param commonHeader
   * @param memberPutParameter
   * @return 更新ステータス(200 or Error)
   */
  fun update(
    commonHeader: CommonHeader,
    memberPutParameter: MemberPutParameter
  ): HttpStatus =
    if (memberRepository.update(search(commonHeader), memberPutParameter)) {
      HttpStatus.OK
    } else {
      throw DbException("Can't update member information.")
    }

  /**
   * 会員情報を削除
   *
   * @param commonHeader
   * @return 削除ステータス(200 or Error)
   */
  fun delete(
    commonHeader: CommonHeader
  ): HttpStatus =
    if (memberRepository.delete(search(commonHeader))) {
      HttpStatus.OK
    } else {
      throw DbException("Can't delete member information.")
    }

  /**
   * サーバ内部用メソッド、DBに保持されている会員情報を取得
   * フロントに表示すべきでないCommonEntityの情報も含む
   *
   * @param commonHeader
   * @return
   */
  fun search(
    commonHeader: CommonHeader
  ): Member = memberRepository.findBy(commonHeader)
    ?: throw UnAuthorizedException("USER NOT FOUND")
}
