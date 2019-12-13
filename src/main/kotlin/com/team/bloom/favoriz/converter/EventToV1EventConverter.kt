package com.team.bloom.favoriz.converter

import com.team.bloom.favoriz.controller.model.V1Event
import com.team.bloom.favoriz.model.Event
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class EventToV1EventConverter : Converter<Event, V1Event> {
    override fun convert(source: Event): V1Event {
        return V1Event(source.id, source.name, source.date.toEpochSecond(), source.type)
    }

    fun convertList(source: List<Event>): List<V1Event> {
        return source.stream().map { event -> convert(event) }.collect(Collectors.toList())
    }
}