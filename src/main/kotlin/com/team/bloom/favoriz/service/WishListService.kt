package com.team.bloom.favoriz.service

import com.team.bloom.favoriz.controller.model.V1WishList
import com.team.bloom.favoriz.converter.V1WishListToWishListConverter
import com.team.bloom.favoriz.repository.WishListRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class WishListService {
    @Autowired
    private lateinit var wishListRepository: WishListRepository
    @Autowired
    private lateinit var converter: V1WishListToWishListConverter

    // TODO : transactoinal working 확인하기
    @Transactional
    fun createWishList(wishList: V1WishList) {
        var wishList = converter.convert(wishList)
        wishListRepository.saveWishList(wishList)
        wishListRepository.saveWishListProductLink(wishList.id, wishList.products)
    }
}