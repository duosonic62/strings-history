package com.littlefeet.infrastracture

import com.littlefeet.domain.entity.Guitar
import com.littlefeet.domain.repository.GuitarDao
import com.littlefeet.domain.repository.GuitarRepository
import org.springframework.stereotype.Component

/**
 * GuitarRepositoroyのコンクリートクラス
 *
 * @property guitarRepository
 */
@Component
class DefaultGuitartRepository(
  private val guitarDao: GuitarDao
) : GuitarRepository {

  override fun findAll(userId: String): List<Guitar> =
    guitarDao.findByUserId(userId)

}
