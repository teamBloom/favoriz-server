package com.team.bloom.favoriz.service

import com.team.bloom.favoriz.model.User
import com.team.bloom.favoriz.model.UserEvent
import com.team.bloom.favoriz.repository.FriendRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class FriendService {
    @Autowired
    private lateinit var friendRepository: FriendRepository

    fun getFriends(id: Long, pageable: Pageable): List<User> =
        friendRepository.getFriends(id, pageable)

    fun getFriendsWithUpcomingEvent(id: Long, pageable: Pageable): List<UserEvent> =
        friendRepository.getFriendsWithUpcomingEvent(id, pageable)

    fun followFriend(id: Long, friendId: Long) =
        friendRepository.followFriend(id, friendId)
}