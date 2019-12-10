package com.team.bloom.favoriz.converter

import com.team.bloom.favoriz.controller.model.V1Event
import com.team.bloom.favoriz.model.Event
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import java.time.OffsetDateTime
import java.time.ZoneOffset

@Component
class V1EventToEventConverter : Converter<V1Event, Event> {
    override fun convert(source: V1Event): Event {
        return Event(
            source.id,
            source.name,
            OffsetDateTime.of(source.date, ZoneOffset.ofHours(9)),
            source.type
        )
    }
}