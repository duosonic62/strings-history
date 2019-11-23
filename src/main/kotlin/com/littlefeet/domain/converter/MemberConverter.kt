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
   * インフラのエンティティをアプリで表示する会員情報にコンバートする
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
   * APIからの作成リクエストをインフラのエンティティに変更
   *
   * @param memberPostParameter
   * @return 会員情報インフラエンティティ
   */
  fun convertCreateMemberParameter(
    memberPostParameter: MemberPostParameter
  ): Member = Member().apply {
    name = memberPostParameter.name
  }

  /**
   * APIからの変更リクエストをインフラのエンティティに変更
   *
   * @param memberPutParameter
   * @param member
   * @return 会員情報インフラエンティティ
   */
  fun convertUpdateMemberParameter(
    memberPutParameter: MemberPutParameter,
    member: Member
  ): Member = member.apply {
    name = memberPutParameter.name
  }

  /**
   * APIからの削除リクエストをインフラのエンティティに変更
   *
   * @param memberPutParameter
   * @param member
   * @return 会員情報インフラエンティティ
   */
  fun convertDeleteMemberParameter(
    member: Member
  ): Member = member.apply { isDeleted = true }
}
