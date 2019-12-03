package com.team.bloom.favoriz.controller

import com.team.bloom.favoriz.external.KakaotalkClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/dev")
class DevController() {

    @Autowired
    private lateinit var kakaotalkClient: KakaotalkClient

    @GetMapping("/test")
    fun test(): String = "test"

    @GetMapping("/kakao-talk/client-id")
    fun getCode(): String? = kakaotalkClient.getCode()

    @GetMapping("/kakao-talk/code")
    fun getCode(@RequestParam("code") code: String): String = code;

}