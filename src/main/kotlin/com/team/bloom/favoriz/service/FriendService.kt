package com.team.bloom.favoriz.service

import com.team.bloom.favoriz.repository.FriendRepository
import com.team.bloom.favoriz.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FriendService {
    @Autowired
    private lateinit var friendRepository: FriendRepository

    fun getFriends(id: Long): List<User> = friendRepository.getFriends(id)

}