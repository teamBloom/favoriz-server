package com.team.bloom.favoriz.controller

import com.team.bloom.favoriz.common.EventType
import com.team.bloom.favoriz.common.PagingApi
import com.team.bloom.favoriz.common.toPageable
import com.team.bloom.favoriz.controller.model.V1Event
import org.springframework.data.domain.PageImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.OffsetDateTime

@RestController("/v1/event")
class EventController {
    @GetMapping("/{id}}")
    fun get(@PathVariable id: Long): V1Event {
        return dummy(id)
    }

    @GetMapping("/list")
    fun list(paging: PagingApi): PageImpl<V1Event> {
        return PageImpl(List(10) { i -> dummy(i.toLong()) }, paging.toPageable(), 10L)
    }

    // TODO : Remove
    fun dummy(id: Long): V1Event =
        V1Event(
            id,
            "test-event",
            OffsetDateTime.now(), EventType.BIRTHDAY
        )

}