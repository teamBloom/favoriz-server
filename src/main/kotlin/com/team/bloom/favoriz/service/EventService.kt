package com.team.bloom.favoriz.service

import com.team.bloom.favoriz.controller.model.V1Event
import com.team.bloom.favoriz.converter.V1EventToEventConverter
import com.team.bloom.favoriz.repository.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EventService {
    @Autowired
    private lateinit var eventRepository: EventRepository
    @Autowired
    private lateinit var converter: V1EventToEventConverter

    fun createEvent(event: V1Event) = eventRepository.save(converter.convert(event))

}