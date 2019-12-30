package com.team.bloom.favoriz.converter

import com.team.bloom.favoriz.controller.model.V1UserEvent
import com.team.bloom.favoriz.model.UserEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class UserEventToV1UserEventConverter : Converter<UserEvent, V1UserEvent> {
    @Autowired
    private lateinit var userConverter: UserToV1UserConverter
    @Autowired
    private lateinit var eventConverter: EventToV1EventConverter

    override fun convert(source: UserEvent): V1UserEvent {
        return V1UserEvent(userConverter.convert(source.user), eventConverter.convert(source.event))
    }

    fun convertList(sourceList: List<UserEvent>): List<V1UserEvent> {
        return sourceList.stream().map { product -> convert(product) }.collect(Collectors.toList())
    }
}