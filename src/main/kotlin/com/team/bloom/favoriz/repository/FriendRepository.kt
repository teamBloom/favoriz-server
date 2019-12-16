package com.team.bloom.favoriz.repository

import com.team.bloom.favoriz.model.User
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
            id,
            RowBounds(pageable.offset, pageable.pageSize)
        );
    }
}