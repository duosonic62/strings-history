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

  /**
   * 自分の所有しているギターを全件取得
   *
   * @param userId
   * @return 所有している全件のギター情報
   */
  override fun findAll(userId: String): List<Guitar> =
    guitarDao.findByUserId(userId)

  /**
   * ギター情報を保存
   *
   * @param guitar
   * @return 保存したギター情報
   */
  override fun put(guitar: Guitar): Boolean =
    guitarDao.insert(guitar) != 1

}
