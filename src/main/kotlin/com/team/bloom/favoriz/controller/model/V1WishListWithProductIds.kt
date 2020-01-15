package com.team.bloom.favoriz.controller.model

data class V1WishListWithProductIds(
    val id: Long,
    val name: String,
    val userId: Long,
    val productIds: List<Long>
)