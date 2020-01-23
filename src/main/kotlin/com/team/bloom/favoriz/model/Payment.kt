package com.team.bloom.favoriz.model

data class Payment(
    val userId: Long,
    val payerId: Long,
    val wishListId: Long,
    val productId: Long,
    val payment: Long
)


