package com.team.bloom.favoriz.service

import com.team.bloom.favoriz.controller.model.V1Event
import com.team.bloom.favoriz.converter.V1EventToEventConverter
import com.team.bloom.favoriz.model.Event
import com.team.bloom.favoriz.repository.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class EventService {
    @Autowired
    private lateinit var eventRepository: EventRepository
    @Autowired
    private lateinit var converter: V1EventToEventConverter

    fun createEvent(userId: Long, event: V1Event) =
        eventRepository.save(converter.convert(userId, event))

    fun getEvent(id: Long, userId: Long): Event = eventRepository.get(id, userId)
    fun getEventList(userId: Long, pageable: Pageable): List<Event> =
        eventRepository.getList(userId, pageable)

}