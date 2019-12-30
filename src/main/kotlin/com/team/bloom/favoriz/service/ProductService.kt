package com.team.bloom.favoriz.service

import com.team.bloom.favoriz.model.Product
import com.team.bloom.favoriz.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProductService {
    @Autowired
    private lateinit var productRepository: ProductRepository

    fun getList(pageable: Pageable): List<Product> = productRepository.getList(pageable)

}