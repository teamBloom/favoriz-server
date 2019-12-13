package com.team.bloom.favoriz.controller.model

import com.team.bloom.favoriz.common.EventType
import io.swagger.annotations.ApiModelProperty

data class V1Event(
    @ApiModelProperty(readOnly = true)
    val id: Long,
    val name: String,
    val timestamp: Long,
    val type: EventType
)


