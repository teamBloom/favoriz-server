package com.team.bloom.favoriz.controller

import com.team.bloom.favoriz.common.PagingApi
import com.team.bloom.favoriz.common.toPageable
import com.team.bloom.favoriz.controller.model.V1Event
import com.team.bloom.favoriz.converter.EventToV1EventConverter
import com.team.bloom.favoriz.service.EventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageImpl
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/users/{userId}")
class EventController {
    @Autowired
    private lateinit var eventService: EventService
    @Autowired
    private lateinit var converter: EventToV1EventConverter

    @GetMapping("/events/{id}}")
    fun get(
        @PathVariable userId: Long,
        @PathVariable id: Long
    ): V1Event {
        return converter.convert(eventService.getEvent(id, userId))
    }

    @GetMapping("/events/list")
    fun list(
        @PathVariable userId: Long,
        paging: PagingApi
    ): PageImpl<V1Event> {
        val result = eventService.getEventList(userId, paging.toPageable())
        return PageImpl(
            converter.convertList(result),
            paging.toPageable(),
            result.size.toLong()
        )
    }

    @PostMapping("/events/create")
    fun create(
        @PathVariable userId: Long,
        @RequestBody event: V1Event
    ) {
        eventService.createEvent(userId, event)
    }
}