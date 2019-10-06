package com.littlefeet.stringshistory.util

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

open class KtLog() {
  var log: Logger = LogManager.getLogger(
    this.javaClass.name.let {
      val matchIndex = it.length - 10
      when (it.lastIndexOf("\$Companion")) {
        matchIndex -> it.substring(0, matchIndex)
        else -> it
      }
    }
  )
}
