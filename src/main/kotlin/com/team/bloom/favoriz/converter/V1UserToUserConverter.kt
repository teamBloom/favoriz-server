package com.team.bloom.favoriz.converter

import com.team.bloom.favoriz.controller.model.V1User
import com.team.bloom.favoriz.model.User
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class V1UserToUserConverter : Converter<V1User, User> {
    override fun convert(source: V1User): User {
        return User(source.uid, source.name, source.thumbnail, source.kuid)
    }

    fun convertList(sourceList: List<V1User>): List<User> {
        return sourceList.stream().map { user -> convert(user) }.collect(Collectors.toList())
    }
}