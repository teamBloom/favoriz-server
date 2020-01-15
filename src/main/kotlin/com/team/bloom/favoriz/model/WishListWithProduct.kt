package com.team.bloom.favoriz.model

data class WishListWithProduct(
    val id: Long,
    val name: String,
    val userId: Long,
    val products: List<Product>
)


