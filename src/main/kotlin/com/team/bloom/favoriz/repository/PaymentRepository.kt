package com.team.bloom.favoriz.repository

import com.team.bloom.favoriz.model.Payment
import com.team.bloom.favoriz.model.WishList
import org.mybatis.spring.SqlSessionTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class PaymentRepository {
    @Autowired
    private lateinit var sqlSessionTemplate: SqlSessionTemplate

    // TODO : UK 중복시 throw exception
    fun save(payment: Payment) {
        sqlSessionTemplate.insert("Payment.insertPayment", payment)
    }
}