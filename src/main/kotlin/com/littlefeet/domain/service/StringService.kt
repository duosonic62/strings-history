package com.littlefeet.domain.service

import com.littlefeet.api.models.StringInformation
import com.littlefeet.api.models.StringRegisterParameter
import com.littlefeet.domain.CommonHeader
import com.littlefeet.domain.converter.StringConverter
import com.littlefeet.domain.repository.GuitarStringDao
import org.springframework.stereotype.Service

@Service
class StringService(
  private val stringDao: GuitarStringDao
) {
  /**
   * 弦情報を作成
   *
   * @param commonHeader
   * @param stringRegisterParameter
   * @return 作成した弦情報
   */
  fun create(
    commonHeader: CommonHeader,
    stringRegisterParameter: StringRegisterParameter
  ): StringInformation {
    val param = StringConverter.convertCreateStringParameter(stringRegisterParameter)
    stringDao.insert(param)
    return StringInformation(
      id = param.id,
      name = param.name,
      description = param.description,
      maker = param.maker,
      thinGauge = param.thinGauge.toInt(),
      thickGauge = param.thickGauge.toInt(),
      url = param.url
    )
  }
}
