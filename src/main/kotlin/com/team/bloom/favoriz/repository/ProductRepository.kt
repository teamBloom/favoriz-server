package com.team.bloom.favoriz.repository

import com.team.bloom.favoriz.model.Product
import org.apache.ibatis.session.RowBounds
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
            RowBounds(pageable.offset, pageable.pageSize)
        )
    }
}