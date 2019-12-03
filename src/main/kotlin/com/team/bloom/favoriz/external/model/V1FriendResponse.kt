package com.team.bloom.favoriz.external.model

import lombok.Data

/**
 * @see <a href = "https://developers.kakao.com/docs/restapi/kakaotalk-api#%EC%B9%9C%EA%B5%AC-%EB%AA%A9%EB%A1%9D"></a>
 */
@Data
data class V1FriendResponse(
    val elements: List<V1FriendElement>,
    val totalCount: Int,
    val favoriteCount: Int,
    val beforeUrl: String,
    val afterUrl: String
)