package com.team.bloom.favoriz.repository

import com.team.bloom.favoriz.model.User
import com.team.bloom.favoriz.model.UserEvent
import org.apache.ibatis.session.RowBounds
import org.mybatis.spring.SqlSessionTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class FriendRepository {
    @Autowired
    private lateinit var sqlSessionTemplate: SqlSessionTemplate

    fun getFriends(id: Long, pageable: Pageable): List<User> {
        return sqlSessionTemplate.selectList(
            "Friend.selectFriends",
            mapOf("id" to id),
            RowBounds(pageable.offset, pageable.pageSize)
        )
    }

    fun getFriendsWithUpcomingEvent(id: Long, pageable: Pageable): List<UserEvent> {
        return sqlSessionTemplate.selectList<UserEvent>(
            "Friend.selectFriendsWithUpcomingEvent",
            id,
            RowBounds(pageable.offset, pageable.pageSize)
        )
    }

    fun followFriend(id: Long, friendId: Long) =
        sqlSessionTemplate.insert("Friend.followFriend", mapOf("id" to id, "friendId" to friendId))

}