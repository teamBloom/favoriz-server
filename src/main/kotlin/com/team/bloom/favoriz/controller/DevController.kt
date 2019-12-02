package com.team.bloom.favoriz.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DevController() {

    @GetMapping("/test")
    fun test(): String = "test"
}