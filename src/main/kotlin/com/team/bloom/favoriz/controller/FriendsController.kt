package com.team.bloom.favoriz.controller

import com.team.bloom.favoriz.common.PagingApi
import com.team.bloom.favoriz.common.toPageable
import com.team.bloom.favoriz.controller.model.V1User
import com.team.bloom.favoriz.controller.model.V1UserEvent
import com.team.bloom.favoriz.converter.UserEventToV1UserEventConverter
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
    @Autowired
    private lateinit var userEventConverter: UserEventToV1UserEventConverter

    @GetMapping("/friends/list")
    fun getFriends(@PathVariable userId: Long, pagingApi: PagingApi): PageImpl<V1User> {
        val result = friendService.getFriends(userId, pagingApi.toPageable())
        return PageImpl(
            converter.convertList(result), pagingApi.toPageable(), result.size.toLong()
        )
    }

    /**
     * Return the friend which has event. Return the result with a upcoming event
     */
    @GetMapping("/friends/events/list")
    fun getFriendsWithUpcomingEvent(@PathVariable userId: Long, pagingApi: PagingApi): PageImpl<V1UserEvent> {
        val friends = friendService.getFriendsWithUpcomingEvent(userId, pagingApi.toPageable())
        return PageImpl(
            userEventConverter.convertList(friends),
            pagingApi.toPageable(),
            friends.size.toLong()
        )
    }


}
