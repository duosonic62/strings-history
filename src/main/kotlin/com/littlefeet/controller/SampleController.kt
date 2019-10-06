package com.littlefeet.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController {

  @GetMapping("/hello")
  suspend fun hello(): HttpStatus =
    HttpStatus.OK
}
