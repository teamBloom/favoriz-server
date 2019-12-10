package com.team.bloom.favoriz.controller

import com.team.bloom.favoriz.common.EventType
import com.team.bloom.favoriz.common.PagingApi
import com.team.bloom.favoriz.common.toPageable
import com.team.bloom.favoriz.controller.model.V1Event
import com.team.bloom.favoriz.converter.EventToV1EventConverter
import com.team.bloom.favoriz.service.EventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.time.LocalDateTime
import java.time.OffsetDateTime

@RestController("/v1/event")
class EventController {
    @Autowired
    private lateinit var eventService: EventService
    @Autowired
    private lateinit var converter: EventToV1EventConverter

    @GetMapping("/{id}}")
    fun get(@PathVariable id: Long): V1Event {
        return dummy(id)
    }

    @GetMapping("/list")
    fun list(paging: PagingApi): PageImpl<V1Event> {
        return PageImpl(List(10) { i -> dummy(i.toLong()) }, paging.toPageable(), 10L)
    }

    @PostMapping("/create")
    fun create(event: V1Event) {
        eventService.createEvent(event)
    }

    // TODO : Remove
    fun dummy(id: Long): V1Event =
        V1Event(
            id,
            "test-event",
            LocalDateTime.now(), EventType.BIRTHDAY
        )

}