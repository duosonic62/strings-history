package com.littlefeet.domain.converter

import com.littlefeet.api.models.GuitarBodyType
import com.littlefeet.api.models.GuitarInformation
import com.littlefeet.domain.entity.Guitar

/**
 * ギター情報の入れ替えを行うクラス
 */
object GuitarConverter {

  /**
   * インフラエンティティからレスポンスエンティティに変換
   *
   * @param guitars
   * @return ギター情報のリストレスポンスエンティティ
   */
  fun convertGuitarListResponse(
    guitars: List<Guitar>
  ): List<GuitarInformation> =
    guitars.map { convertGuitarResponse(it) }

  /**
   * インフラエンティティからレスポンスエンティティに変換
   *
   * @param guitar
   * @return ギター情報のレスポンスエンティティ
   */
  private fun convertGuitarResponse(
    guitar: Guitar
  ): GuitarInformation =
    GuitarInformation(
      id = guitar.id,
      name = guitar.name,
      description = guitar.description,
      maker = guitar.maker,
      bodyType = GuitarBodyType.valueOf(guitar.bodyType),
      imageUrl = guitar.imageUrl
    )
}
