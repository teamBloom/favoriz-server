package com.team.bloom.favoriz.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/dev")
class DevController() {

    @GetMapping("/test")
    fun test(): String = "test"
}