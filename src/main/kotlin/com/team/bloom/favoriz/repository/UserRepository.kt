package com.team.bloom.favoriz.repository

import com.team.bloom.favoriz.model.User
import com.team.bloom.favoriz.model.WishList
import org.mybatis.spring.SqlSessionTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserRepository {
    @Autowired
    private lateinit var sqlSessionTemplate: SqlSessionTemplate

    fun saveUser(user: User) {
        sqlSessionTemplate.insert("User.insertUser", user)
    }

    fun getUser(userId: Long): User? {
        return sqlSessionTemplate.selectOne("User.selectUser", mapOf("id" to userId))
    }
}