package com.team.bloom.favoriz.converter

import com.team.bloom.favoriz.controller.model.V1Product
import com.team.bloom.favoriz.model.Product
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class ProductToV1ProductConverter : Converter<Product, V1Product> {
    override fun convert(source: Product): V1Product {
        return V1Product(source.id, source.name, source.price, source.thumbnail)
    }

    fun convertList(sourceList: List<Product>): List<V1Product> {
        return sourceList.stream().map { product -> convert(product) }.collect(Collectors.toList())
    }
}