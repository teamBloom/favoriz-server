package com.team.bloom.favoriz.repository

import com.team.bloom.favoriz.model.WishList
import org.mybatis.spring.SqlSessionTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class WishListRepository {
    @Autowired
    private lateinit var sqlSessionTemplate: SqlSessionTemplate

    // TODO : UK 중복시 throw exception
    fun saveWishList(wishList: WishList) {
        sqlSessionTemplate.insert("WishList.insertWishList", wishList)
    }

    fun saveWishListProductLink(wishListId: Long, products: List<Long>) {
        for (it in products) {
            sqlSessionTemplate.insert(
                "WishList.insertWishListProductLink",
                mapOf("wishListId" to wishListId, "productId" to it)
            )
        }
    }
}