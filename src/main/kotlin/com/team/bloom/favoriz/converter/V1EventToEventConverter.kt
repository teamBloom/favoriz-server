package com.team.bloom.favoriz.converter

import com.team.bloom.favoriz.controller.model.V1Event
import com.team.bloom.favoriz.model.Event
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneId

@Component
class V1EventToEventConverter {
    fun convert(userId: Long, source: V1Event): Event {
        return Event(
            source.id,
            source.name,
            OffsetDateTime.ofInstant(Instant.ofEpochSecond(source.timestamp), ZoneId.of("UTC+9")),
            source.type,
            userId
        )
    }
}