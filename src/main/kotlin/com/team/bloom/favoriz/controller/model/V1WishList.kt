package com.team.bloom.favoriz.controller.model

data class V1WishList(val id: Long, val name: String, val userId: Long, val products: List<Long>)