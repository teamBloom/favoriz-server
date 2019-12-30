package com.team.bloom.favoriz.model

data class WishList(
    val id: Long,
    val name: String,
    val userId: Long,
    val products: List<Long>
)