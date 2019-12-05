package com.team.bloom.favoriz.common

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

class PagingApi(val page: Int = 0, val size: Int = 10, val sort: Sort = Sort("{}")) {
    init {
    }
}

fun PagingApi.toPageable(): Pageable {
    return PageRequest(page, size, sort)
}

