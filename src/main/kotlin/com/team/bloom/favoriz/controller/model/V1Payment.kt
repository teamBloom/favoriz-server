package com.team.bloom.favoriz.controller.model

data class V1Payment(
    val userId: Long,
    val payerId: Long,
    val wishListId: Long,
    val productId: Long,
    val payment: Long
)