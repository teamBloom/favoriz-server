package com.team.bloom.favoriz.controller

import com.team.bloom.favoriz.common.PagingApi
import com.team.bloom.favoriz.common.toPageable
import com.team.bloom.favoriz.controller.model.V1Product
import com.team.bloom.favoriz.converter.ProductToV1ProductConverter
import com.team.bloom.favoriz.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/product")
class ProductController() {
    @Autowired
    private lateinit var productService: ProductService
    @Autowired
    private lateinit var converter: ProductToV1ProductConverter

    @GetMapping("/list")
    fun getProductList(pagingApi: PagingApi): PageImpl<V1Product> {
        val result = productService.getList(pagingApi.toPageable())
        return PageImpl(converter.convertList(result), pagingApi.toPageable(), result.size.toLong())
    }


}
