package com.littlefeet.domain.service

import com.littlefeet.api.models.StringInformation
import com.littlefeet.api.models.StringRegisterParameter
import com.littlefeet.domain.CommonHeader
import com.littlefeet.domain.entity.GuitarString
import com.littlefeet.domain.repository.GuitarStringDao
import org.springframework.stereotype.Service

@Service
class StringService(
  private val stringDao: GuitarStringDao
) {
  fun create(
    commonHeader: CommonHeader,
    stringRegisterParameter: StringRegisterParameter
  ): StringInformation {
    val param = GuitarString().apply {
      name = stringRegisterParameter.name
      description = stringRegisterParameter.description
      maker = stringRegisterParameter.maker
      thickGauge = stringRegisterParameter.thinGauge.toShort()
      thickGauge = stringRegisterParameter.thickGauge.toShort()
      url = stringRegisterParameter.url
    }
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
