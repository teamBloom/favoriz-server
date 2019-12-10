package com.team.bloom.favoriz.repository

import com.team.bloom.favoriz.model.Event
import org.mybatis.spring.SqlSessionTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class EventRepository {
    @Autowired
    private lateinit var sqlSessionTemplate: SqlSessionTemplate

    fun save(event: Event) {
        sqlSessionTemplate.insert("Event.insertEvent", event);
    }
}