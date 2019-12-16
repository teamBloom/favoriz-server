package com.team.bloom.favoriz.repository

import com.team.bloom.favoriz.model.Event
import org.apache.ibatis.session.RowBounds
import org.mybatis.spring.SqlSessionTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class EventRepository {
    @Autowired
    private lateinit var sqlSessionTemplate: SqlSessionTemplate

    fun save(event: Event) {
        sqlSessionTemplate.insert("Event.insertEvent", event);
    }

    fun get(id: Long, userId: Long): Event {
        return sqlSessionTemplate.selectOne(
            "Event.selectEvent",
            mapOf("id" to id)
        )
    }

    fun getList(userId: Long, pageable: Pageable): List<Event> {
        return sqlSessionTemplate.selectList(
            "Event.selectEventList",
            userId,
            RowBounds(pageable.offset, pageable.pageSize)
        )
    }
}