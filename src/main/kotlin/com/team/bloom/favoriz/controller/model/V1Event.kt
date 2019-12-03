package com.team.bloom.favoriz.controller.model

import com.team.bloom.favoriz.common.EventType
import java.time.OffsetDateTime

data class V1Event(
    val id: Long,
    val name: String,
    val date: OffsetDateTime,
    val type: EventType
)


