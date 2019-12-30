package com.team.bloom.favoriz.model

import com.team.bloom.favoriz.common.EventType
import java.time.OffsetDateTime

data class UserEvent(val user: User, val event: Event) {
    constructor(
        id: Long,
        name: String,
        eventId: Long,
        eventName: String,
        eventDate: OffsetDateTime,
        type: EventType
    ) : this(User(id, name), Event(eventId, eventName, eventDate, type, id))
}

