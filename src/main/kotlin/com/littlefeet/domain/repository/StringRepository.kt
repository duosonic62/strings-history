package com.littlefeet.domain.repository

import com.littlefeet.api.models.StringRegisterParameter
import com.littlefeet.domain.entity.GuitarString
import org.springframework.stereotype.Repository

/**
 * ギター弦に関する永続化の責務を果たすインターフェース
 *
 */
@Repository
interface StringRepository {
  fun findBy(id: String): GuitarString?

  fun findBy(
    name: String? = null,
    maker: String? = null,
    thinGage: Int? = null,
    thickGage: Int? = null
  ): List<GuitarString>

  fun put(stringRegisterParameter: StringRegisterParameter): Boolean

  fun update(string: GuitarString, stringRegisterParameter: StringRegisterParameter): Boolean

  fun delete(string: GuitarString): Boolean
}
