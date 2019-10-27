package com.littlefeet.domain.converter

import com.littlefeet.api.models.MemberInformation
import com.littlefeet.api.models.MemberPostParameter
import com.littlefeet.api.models.MemberPutParameter
import com.littlefeet.domain.entity.Member

/**
 * 会員情報のオブジェクト入れ替えを行うクラス
 */
object MemberConverter {
  /**
   * DBのエンティティをアプリで表示する会員情報にコンバートする
   *
   * @param member
   * @return アプリ表示会員情報
   */
  fun convertShowMemberResponse(
    member: Member
  ): MemberInformation =
    MemberInformation(
      name = member.name
    )

  /**
   * APIからの作成リクエストをDBのエンティティに変更
   *
   * @param memberPostParameter
   * @return 会員情報DBエンティティ
   */
  fun convertCreateMemberParameter(
    memberPostParameter: MemberPostParameter
  ): Member = Member().apply {
    name = memberPostParameter.name
  }

  /**
   * APIからの変更リクエストをDBのエンティティに変更
   *
   * @param memberPutParameter
   * @param member
   * @return 会員情報DBエンティティ
   */
  fun convertUpdateMemberParameter(
    memberPutParameter: MemberPutParameter,
    member: Member
  ): Member = member.apply {
    name = memberPutParameter.name
  }

  /**
   * APIからの削除リクエストをDBのエンティティに変更
   *
   * @param memberPutParameter
   * @param member
   * @return 会員情報DBエンティティ
   */
  fun convertDeleteMemberParameter(
    member: Member
  ): Member = member.apply { isDeleted = true }
}
