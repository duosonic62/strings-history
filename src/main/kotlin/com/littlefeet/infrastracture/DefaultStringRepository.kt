package com.littlefeet.infrastracture

import com.littlefeet.api.models.StringRegisterParameter
import com.littlefeet.domain.converter.StringConverter
import com.littlefeet.domain.entity.GuitarString
import com.littlefeet.domain.repository.GuitarStringDao
import com.littlefeet.domain.repository.StringRepository
import org.springframework.stereotype.Component

@Component
class DefaultStringRepository(
  private val stringDao: GuitarStringDao
) : StringRepository {
  override fun findBy(id: String): GuitarString? =
    stringDao.selectById(id)

  override fun findBy(name: String?, maker: String?, thinGage: Int?, thickGage: Int?): List<GuitarString> =
    stringDao.selectByNameOrMakerOrGage(name, maker, thinGage, thickGage)

  override fun put(stringRegisterParameter: StringRegisterParameter): Boolean =
    stringDao.insert(
      StringConverter.convertRegisterStringParameter(stringRegisterParameter)
    ) == 1

  override fun update(string: GuitarString, stringRegisterParameter: StringRegisterParameter): Boolean =
    stringDao.update(
      StringConverter.convertUpdateStringParameter(string, stringRegisterParameter)
    ) == 1

  override fun delete(string: GuitarString): Boolean =
    stringDao.update(
      string.apply { isDeleted = true }
    ) == 1
}
