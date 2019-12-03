package com.team.bloom.favoriz.service

import com.team.bloom.favoriz.external.KakaotalkClient
import com.team.bloom.favoriz.external.model.V1FriendElement
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class FriendService {
    @Autowired
    private lateinit var kakaotalkClient: KakaotalkClient

    fun getFriends(token: String): List<V1FriendElement> =
        Optional.ofNullable(kakaotalkClient.getFriend(token))
            .map { it -> it.elements }
            .orElse(listOf());
}