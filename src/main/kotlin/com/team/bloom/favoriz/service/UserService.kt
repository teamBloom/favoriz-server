package com.team.bloom.favoriz.service

import com.team.bloom.favoriz.controller.model.V1User
import com.team.bloom.favoriz.converter.V1UserToUserConverter
import com.team.bloom.favoriz.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    private lateinit var userRepository: UserRepository
    @Autowired
    private lateinit var converter: V1UserToUserConverter

    fun createUser(user: V1User) =
        userRepository.saveUser(converter.convert(user))

}