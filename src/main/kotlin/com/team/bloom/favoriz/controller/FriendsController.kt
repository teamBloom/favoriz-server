package com.team.bloom.favoriz.controller

import com.team.bloom.favoriz.common.PagingApi
import com.team.bloom.favoriz.common.toPageable
import com.team.bloom.favoriz.controller.model.V1User
import com.team.bloom.favoriz.converter.UserToV1UserConverter
import com.team.bloom.favoriz.service.FriendService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/users/{userId}")
class FriendsController() {
    @Autowired
    private lateinit var friendService: FriendService
    @Autowired
    private lateinit var converter: UserToV1UserConverter

    @GetMapping("/friends/list")
    fun getFriends(@PathVariable userId: Long, pageable: PagingApi): PageImpl<V1User> =
        PageImpl(
            converter.convertList(friendService.getFriends(userId)), pageable.toPageable(), 10L
        )

}
