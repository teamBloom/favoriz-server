package com.team.bloom.favoriz.model

import com.team.bloom.favoriz.common.EventType
import java.time.OffsetDateTime

data class Event(
    val id: Long,
    val name: String,
    val date: OffsetDateTime,
    val type: EventType,
    val userId: Long
)