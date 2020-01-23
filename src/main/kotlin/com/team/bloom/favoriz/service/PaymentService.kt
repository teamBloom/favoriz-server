package com.team.bloom.favoriz.service

import com.team.bloom.favoriz.exception.InvalidRequestException
import com.team.bloom.favoriz.model.Payment
import com.team.bloom.favoriz.model.Product
import com.team.bloom.favoriz.repository.PaymentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PaymentService {
    @Autowired
    private lateinit var paymentRepository: PaymentRepository
    @Autowired
    private lateinit var wishListService: WishListService

    @Transactional
    fun pay(payment: Payment) {
        // check if product id is involve in wishlist
        val wishList = wishListService.getList(payment.userId)
        if (wishList == null || wishList.products.stream().map { Product::id }.filter { it ->
                it.equals(
                    payment.productId
                )
            }.findAny().isEmpty) {
            throw InvalidRequestException()
        }
        paymentRepository.save(payment)
    }
}