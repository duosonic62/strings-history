package com.littlefeet.domain.converter

import com.littlefeet.api.models.StringInformation
import com.littlefeet.api.models.StringRegisterParameter
import com.littlefeet.domain.entity.GuitarString

/**
 * 弦情報のオブジェクト入れ替えを行うクラス
 */
object StringConverter {
  /**
   * APIからの作成リクエストをインフラのエンティティに変換
   *
   * @param stringRegisterParameter
   * @return 弦登録インフラエンティティ
   */
  fun convertRegisterStringParameter(
    stringRegisterParameter: StringRegisterParameter
  ): GuitarString = GuitarString().apply {
    name = stringRegisterParameter.name
    description = stringRegisterParameter.description
    maker = stringRegisterParameter.maker
    thickGauge = stringRegisterParameter.thinGauge.toShort()
    thickGauge = stringRegisterParameter.thickGauge.toShort()
    url = stringRegisterParameter.url
  }

  /**
   * APIからの変更リクエストをインフラのエンティティに変換
   *
   * @param stringRegisterParameter
   * @return 弦登録インフラエンティティ
   */
  fun convertUpdateStringParameter(
    string: GuitarString,
    stringRegisterParameter: StringRegisterParameter
  ): GuitarString = string.apply {
    name = stringRegisterParameter.name
    description = stringRegisterParameter.description
    maker = stringRegisterParameter.maker
    thickGauge = stringRegisterParameter.thinGauge.toShort()
    thickGauge = stringRegisterParameter.thickGauge.toShort()
    url = stringRegisterParameter.url
  }

  /**
   * 弦情報のインフラエンティティからレスポンスエンティティに変換
   *
   * @param guitarString
   * @return 弦情報レスポンスエンティティ
   */
  fun convertStringResponse(
    guitarString: GuitarString
  ): StringInformation = StringInformation(
    id = guitarString.id,
    name = guitarString.name,
    description = guitarString.description,
    maker = guitarString.maker,
    thinGauge = guitarString.thinGauge.toInt(),
    thickGauge = guitarString.thickGauge.toInt(),
    url = guitarString.url
  )

}
