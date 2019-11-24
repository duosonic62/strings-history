package com.littlefeet.service

import com.littlefeet.api.models.StringInformation
import com.littlefeet.api.models.StringRegisterParameter
import com.littlefeet.domain.CommonHeader
import com.littlefeet.domain.converter.StringConverter
import com.littlefeet.domain.repository.GuitarStringDao
import org.springframework.http.HttpStatus
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
    return StringConverter.convertStringResponse(param)
  }

  /**
   * 弦情報を更新
   *
   * @param commonHeader
   * @param stringRegisterParameter
   * @return 更新状況
   */
  fun update(
    commonHeader: CommonHeader,
    stringRegisterParameter: StringRegisterParameter
  ): HttpStatus {
    val param = StringConverter.convertCreateStringParameter(stringRegisterParameter)
    stringDao.update(param)
    return HttpStatus.OK
  }
}
