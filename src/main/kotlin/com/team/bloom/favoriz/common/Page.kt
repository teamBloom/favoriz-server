package com.team.bloom.favoriz.common

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

class Page(val page: Int = 0, val size: Int = 10, val sort: Sort = Sort("{}")) {
    init {
    }
}

fun Page.toPageable(): Pageable {
    return PageRequest(page, size, sort)
}

