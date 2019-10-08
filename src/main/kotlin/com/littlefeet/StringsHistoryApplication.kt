package com.littlefeet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StringsHistoryApplication {
  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      runApplication<StringsHistoryApplication>(*args)
    }
  }
}
