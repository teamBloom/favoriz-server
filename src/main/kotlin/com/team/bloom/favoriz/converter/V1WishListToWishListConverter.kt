package com.team.bloom.favoriz.converter

import com.team.bloom.favoriz.controller.model.V1WishList
import com.team.bloom.favoriz.model.WishList
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class V1WishListToWishListConverter : Converter<V1WishList, WishList> {
    override fun convert(source: V1WishList): WishList {
        return WishList(source.id, source.name, source.userId, source.products)
    }

}