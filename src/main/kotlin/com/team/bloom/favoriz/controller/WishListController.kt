package com.team.bloom.favoriz.controller

import com.team.bloom.favoriz.controller.model.V1WishListWithProductIds
import com.team.bloom.favoriz.model.WishListWithProduct
import com.team.bloom.favoriz.service.WishListService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/users/{userId}")
class WishListController() {
    @Autowired
    private lateinit var wishListService: WishListService

    @PostMapping("/wish/create")
    fun createWishList(@PathVariable userId: Long, @RequestBody wishListWithProductIds: V1WishListWithProductIds) {
        wishListService.createWishList(wishListWithProductIds)
    }

    @GetMapping("/list")
    fun getWishList(@PathVariable userId: Long): WishListWithProduct {
        return wishListService.getList(userId)
    }
}
