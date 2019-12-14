package com.littlefeet.domain.repository

import com.littlefeet.domain.entity.Guitar

interface GuitarRepository {
  fun findAll(guitarId: String): List<Guitar>
}
