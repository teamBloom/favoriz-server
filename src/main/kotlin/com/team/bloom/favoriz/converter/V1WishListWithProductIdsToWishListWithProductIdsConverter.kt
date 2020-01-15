package com.team.bloom.favoriz.converter

import com.team.bloom.favoriz.controller.model.V1WishListWithProductIds
import com.team.bloom.favoriz.model.WishListWithProductIds
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class V1WishListWithProductIdsToWishListWithProductIdsConverter :
    Converter<V1WishListWithProductIds, WishListWithProductIds> {
    override fun convert(source: V1WishListWithProductIds): WishListWithProductIds {
        return WishListWithProductIds(source.id, source.name, source.userId, source.productIds)
    }

}