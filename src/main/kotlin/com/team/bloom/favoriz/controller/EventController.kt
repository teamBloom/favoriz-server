package com.team.bloom.favoriz.controller

import com.team.bloom.favoriz.controller.model.V1User
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/v1/event")
class EventController {
    @PostMapping("/create")
    fun create(@RequestBody user: V1User) {

    }
}