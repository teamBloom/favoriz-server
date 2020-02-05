package com.team.bloom.favoriz.controller.model

data class V1User(
    val uid: Long,
    val name: String,
    val thumbnail: String,
    val kuid: String?
)