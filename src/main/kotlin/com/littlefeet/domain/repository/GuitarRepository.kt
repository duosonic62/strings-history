package com.littlefeet.domain.repository

import com.littlefeet.domain.entity.Guitar

interface GuitarRepository {
  fun findByIdAndMemberId(guitarId: String, memberId: String): Guitar?
  fun findAll(memberId: String): List<Guitar>
  fun put(guitar: Guitar): Boolean
  fun update(guitar: Guitar): Boolean
}
