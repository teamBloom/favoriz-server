package com.team.bloom.favoriz.controller.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.team.bloom.favoriz.common.EventType
import io.swagger.annotations.ApiModelProperty
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

data class V1Event(
    @ApiModelProperty(readOnly = true)
    val id: Long,
    val name: String,
    @ApiModelProperty(required = true, example = "2000-10-31T01:30:00.000-05:00")
    @JsonFormat(pattern = "2000-10-31T01:30:00.000-05:00")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val date: LocalDateTime,
    val type: EventType
)


