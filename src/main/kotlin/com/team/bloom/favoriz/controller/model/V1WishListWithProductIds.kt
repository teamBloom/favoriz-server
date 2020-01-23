package com.team.bloom.favoriz.controller.model

import java.time.OffsetDateTime

data class V1WishListWithProductIds(
    val id: Long,
    val name: String? = OffsetDateTime.now().toString(),
    val userId: Long,
    val productIds: List<Long>
)