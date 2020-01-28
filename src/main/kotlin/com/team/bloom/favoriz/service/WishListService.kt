package com.team.bloom.favoriz.service

import com.team.bloom.favoriz.controller.model.V1WishListWithProductIds
import com.team.bloom.favoriz.converter.V1WishListWithProductIdsToWishListWithProductIdsConverter
import com.team.bloom.favoriz.model.WishList
import com.team.bloom.favoriz.model.WishListProduct
import com.team.bloom.favoriz.model.WishListWithProduct
import com.team.bloom.favoriz.repository.PaymentRepository
import com.team.bloom.favoriz.repository.ProductRepository
import com.team.bloom.favoriz.repository.WishListRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class WishListService {
    @Autowired
    private lateinit var wishListRepository: WishListRepository
    @Autowired
    private lateinit var productRepository: ProductRepository
    @Autowired
    private lateinit var paymentRepository: PaymentRepository
    @Autowired
    private lateinit var withProductIdsConverterWithProductIds: V1WishListWithProductIdsToWishListWithProductIdsConverter

    // TODO : transactoinal working 확인하기
    @Transactional
    fun createWishList(wishListWithProductIds: V1WishListWithProductIds) {
        var wishListWithProductIds =
            withProductIdsConverterWithProductIds.convert(wishListWithProductIds)
        wishListRepository.saveWishList(
            WishList(
                wishListWithProductIds.id,
                wishListWithProductIds.name,
                wishListWithProductIds.userId
            )
        )
        wishListRepository.saveWishListProductLink(
            wishListWithProductIds.id,
            wishListWithProductIds.productIds
        )
    }

    fun getList(userId: Long): WishListWithProduct? {
        val wishList = wishListRepository.getWishList(userId)
        if (wishList == null) {
            return null
        }
        val products = productRepository.getProductsByWishListId(wishList.id)

        val productWithPayment =
            products.map { it ->
                WishListProduct(it, paymentRepository.getPaymentSum(userId, it.id))
            }.toList()

        return WishListWithProduct(wishList.id, wishList.name, wishList.userId, productWithPayment)
    }
}