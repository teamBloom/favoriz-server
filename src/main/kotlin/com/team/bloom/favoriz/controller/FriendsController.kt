package com.team.bloom.favoriz.controller

import com.team.bloom.favoriz.common.Page
import com.team.bloom.favoriz.common.toPageable
import com.team.bloom.favoriz.controller.model.V1Event
import com.team.bloom.favoriz.controller.model.V1Friend
import org.springframework.data.domain.PageImpl
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.OffsetDateTime

@RestController("/v1/friends")
class FriendsController() {

    @GetMapping("/list")
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
        @PageableDefault() pageable: Page
    ): PageImpl<V1Friend> = PageImpl(List(10) { i -> dummy(i) }, pageable.toPageable(), 10L)

    // TODO : TEMPORARY CODE remove this
    fun dummy(id: Int): V1Friend =
        V1Friend(id.toString(), "test-friend", V1Event(1, "test-event", OffsetDateTime.now()))


}
