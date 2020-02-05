package com.team.bloom.favoriz.controller

import com.team.bloom.favoriz.controller.model.V1User
import com.team.bloom.favoriz.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/users")
class UserController() {
    @Autowired
    private lateinit var userService: UserService

    @PostMapping("/create")
    fun create(@RequestBody user: V1User) {
        userService.createUser(user)
    }

}
