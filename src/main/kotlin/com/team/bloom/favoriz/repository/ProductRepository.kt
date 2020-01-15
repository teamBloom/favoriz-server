package com.team.bloom.favoriz.repository

import com.team.bloom.favoriz.model.Product
import org.mybatis.spring.SqlSessionTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class ProductRepository {
    @Autowired
    private lateinit var sqlSessionTemplate: SqlSessionTemplate

    fun getList(pageable: Pageable): List<Product> {
        return sqlSessionTemplate.selectList(
            "Product.selectProductList",
            mapOf("offset" to pageable.offset, "limit" to pageable.pageSize)
        );
    }

    fun getProductsByWishListId(wishListId: Long): List<Product> {
        return sqlSessionTemplate.selectList(
            "Product.selectProductsByIds",
            mapOf("wishListId" to wishListId)
        )
    }
}