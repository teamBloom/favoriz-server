package com.team.bloom.favoriz.external

import com.team.bloom.favoriz.common.logger
import com.team.bloom.favoriz.external.model.V1FriendResponse
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.net.URI


const val GET_FRIENDS_URL = "/v1/api/talk/friends"
const val GET_AUTHORIZE =
    "/oauth/authorize?client_id=64f456f00c3118dced8629df662425ad&response_type=code&redirect_uri=http://localhost:8080/v1/dev/kakao-talk/redirect"

@Slf4j
@Component
class KakaotalkClient {
    val logger = logger<KakaotalkClient>()

    @Autowired
    private lateinit var restTemplate: RestTemplate

    fun getCode(): String? {
        return restTemplate.getForObject(
            "https://kauth.kakao.com" + GET_AUTHORIZE,
            String::class.java
        )
    }

    fun getFriend(token: String): V1FriendResponse? {
        // TODO : make host property
        try {
            val headers: HttpHeaders = HttpHeaders()
            headers.add("Authorization", "Bearer " + token)
            return restTemplate.exchange(
                URI("https://kapi.kakao.com" + GET_FRIENDS_URL),
                HttpMethod.GET,
                HttpEntity(null, headers),
                V1FriendResponse::class.java
            ).body
        } catch (e: Exception) {
            logger.error("Error occurs while getting friends from KakaoTalk")
        }
        return null
    }

}