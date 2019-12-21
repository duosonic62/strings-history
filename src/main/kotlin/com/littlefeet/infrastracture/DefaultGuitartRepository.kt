package com.littlefeet.infrastracture

import com.littlefeet.domain.entity.Guitar
import com.littlefeet.domain.repository.GuitarDao
import com.littlefeet.domain.repository.GuitarRepository
import org.springframework.stereotype.Component

/**
 * GuitarRepositoroyのコンクリートクラス
 *
 * @property guitarDao
 */
@Component
class DefaultGuitarRepository(
  private val guitarDao: GuitarDao
) : GuitarRepository {

  /**
   * 自分が所有しているギターをIDで取得
   *
   * @param guitarId
   * @param memberId
   * @return idで指定されたギター情報
   */
  override fun findByIdAndMemberId(guitarId: String, memberId: String): Guitar? =
    guitarDao.findByIdAndMemberId(guitarId, memberId)

  /**
   * 自分の所有しているギターを全件取得
   *
   * @param memberId
   * @return 所有している全件のギター情報
   */
  override fun findAll(memberId: String): List<Guitar> =
    guitarDao.findByMemberId(memberId)

  /**
   * ギター情報を保存
   *
   * @param guitar
   * @return 保存状況
   */
  override fun put(guitar: Guitar): Boolean =
    guitarDao.insert(guitar) == 1

  /**
   * ギター情報を変更
   *
   * @param guitar
   * @return 保存状況
   */
  override fun update(guitar: Guitar): Boolean =
    guitarDao.update(guitar) == 1
}
