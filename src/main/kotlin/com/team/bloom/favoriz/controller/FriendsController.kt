package com.team.bloom.favoriz.controller

import com.team.bloom.favoriz.common.EventType
import com.team.bloom.favoriz.common.PagingApi
import com.team.bloom.favoriz.common.toPageable
import com.team.bloom.favoriz.controller.model.V1Event
import com.team.bloom.favoriz.controller.model.V1User
import com.team.bloom.favoriz.external.model.V1FriendElement
import com.team.bloom.favoriz.service.FriendService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageImpl
import org.springframework.web.bind.annotation.*
import java.time.OffsetDateTime

@RestController
@RequestMapping("/v1/friends")
class FriendsController() {
    @Autowired
    private lateinit var friendService: FriendService

    @GetMapping("/list")
    fun getKakaoTalkFriends(@RequestBody token: String): List<V1FriendElement> =
        friendService.getFriends(token)

    @GetMapping("/event/list")
    fun getFriends(
        @RequestParam(
            "startDateTime",
            required = false
        ) startDateTime: OffsetDateTime?,
        @RequestParam(
            "endDateTime",
            required = false
        )
        endDateTime: OffsetDateTime?,
        pageable: PagingApi
    ): PageImpl<V1User> = PageImpl(List(10) { i -> dummy(i) }, pageable.toPageable(), 10L)

    // TODO : TEMPORARY CODE remove this
    fun dummy(id: Int): V1User =
        V1User(
            id.toString(),
            "test-friend",
            V1Event(1, "test-event", OffsetDateTime.now(), EventType.BIRTHDAY)
        )


}
