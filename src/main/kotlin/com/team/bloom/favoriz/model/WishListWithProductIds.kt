package com.team.bloom.favoriz.model

data class WishListWithProductIds(
    val id: Long,
    val name: String?,
    val userId: Long,
    val productIds: List<Long>
)


