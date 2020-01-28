package com.team.bloom.favoriz.model

data class WishListWithProduct(
    val id: Long,
    val name: String?,
    val userId: Long,
    val products: List<WishListProduct>
)

data class WishListProduct(
    val id: Long, val name: String, val price: Long, val thumbnail: String, val payment: Long
) {
    constructor(
        product: Product,
        payment: Long
    ) : this(product.id, product.name, product.price, product.thumbnail, payment)
}


