package com.team.bloom.favoriz.external.model

/**
 * @see <a href = "https://developers.kakao.com/docs/restapi/kakaotalk-api#%EC%B9%9C%EA%B5%AC-%EB%AA%A9%EB%A1%9D"></a>
 */
data class V1FriendElement(
    val id: Long,
    val uuid: String,
    val profileNickname: String,
    val profileThumbnailImage: String,
    val favorite: String
)
