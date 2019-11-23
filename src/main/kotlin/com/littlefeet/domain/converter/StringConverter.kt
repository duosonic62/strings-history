package com.littlefeet.domain.converter

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
  fun convertCreateStringParameter(
    stringRegisterParameter: StringRegisterParameter
  ): GuitarString = GuitarString().apply {
    name = stringRegisterParameter.name
    description = stringRegisterParameter.description
    maker = stringRegisterParameter.maker
    thickGauge = stringRegisterParameter.thinGauge.toShort()
    thickGauge = stringRegisterParameter.thickGauge.toShort()
    url = stringRegisterParameter.url
  }

}
