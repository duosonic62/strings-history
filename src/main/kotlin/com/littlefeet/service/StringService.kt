package com.littlefeet.service

import com.littlefeet.api.models.StringInformation
import com.littlefeet.api.models.StringRegisterParameter
import com.littlefeet.domain.CommonHeader
import com.littlefeet.domain.converter.StringConverter
import com.littlefeet.domain.exception.DbException
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
    val param = StringConverter.convertRegisterStringParameter(stringRegisterParameter)
    if (stringDao.insert(param) != 1) throw DbException("Can't Register String.")
    return StringConverter.convertStringResponse(param)
  }

  /**
   * 弦情報を更新
   *
   * @param commonHeader
   * @param id
   * @param stringRegisterParameter
   * @return 更新状況
   */
  fun update(
    commonHeader: CommonHeader,
    id: String,
    stringRegisterParameter: StringRegisterParameter
  ): HttpStatus {
    val param = StringConverter.convertRegisterStringParameter(stringRegisterParameter)
    if (stringDao.update(param) != 1) throw DbException("Can't Register String.")
    return HttpStatus.OK
  }

  /**
   * 弦情報を削除
   *
   * @param id
   * @param commonHeader
   * @return 削除状況
   */
  fun delete(
    id: String,
    commonHeader: CommonHeader
  ): HttpStatus {
    val param = stringDao.selectById(id)
    param.isDeleted = true
    if (stringDao.update(param) != 1) throw  DbException("Can't Delete String.")
    return HttpStatus.OK
  }

  /**
   * 弦情報を検索
   *
   * @param commonHeader
   * @param name
   * @param maker
   * @param thinGage
   * @param thickGage
   * @return 弦情報
   */
  fun search(
    commonHeader: CommonHeader,
    name: String? = null,
    maker: String? = null,
    thinGage: Int? = null,
    thickGage: Int? = null
  ): List<StringInformation> =
    stringDao.selectByNameOrMakerOrGage(name, maker, thinGage, thickGage)
      .map { StringConverter.convertStringResponse(it) }
}
