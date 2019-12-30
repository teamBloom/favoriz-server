package com.team.bloom.favoriz.converter

import com.team.bloom.favoriz.controller.model.V1User
import com.team.bloom.favoriz.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class UserToV1UserConverter : Converter<User, V1User> {
    override fun convert(source: User): V1User {
        return V1User(source.id, source.name)
    }

    fun convertList(sourceList: List<User>): List<V1User> {
        return sourceList.stream().map { user -> convert(user) }.collect(Collectors.toList())
    }
}