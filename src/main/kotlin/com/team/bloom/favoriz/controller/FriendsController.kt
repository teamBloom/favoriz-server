package com.team.bloom.favoriz.controller

import com.team.bloom.favoriz.controller.model.V1Event
import com.team.bloom.favoriz.controller.model.V1Friend
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.OffsetDateTime

@RestController("/v1/friends")
class FriendsController() {

    @GetMapping("/list")
    // TODO : Add paging
    fun getFriends(
        @RequestParam(
            "startDateTime",
            required = false
        ) startDateTime: OffsetDateTime?,
        @RequestParam(
            "endDateTime",
            required = false
        )
        endDateTime: OffsetDateTime?
    ): List<V1Friend> = List(10) { i -> dummy(i) }

    // TODO : TEMPORARY CODE remove this
    fun dummy(id: Int): V1Friend =
        V1Friend(id.toString(), "test-friend", V1Event(1, "test-event", OffsetDateTime.now()))


}
