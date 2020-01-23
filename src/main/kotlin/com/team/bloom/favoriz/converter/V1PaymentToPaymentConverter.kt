package com.team.bloom.favoriz.converter

import com.team.bloom.favoriz.controller.model.V1Payment
import com.team.bloom.favoriz.model.Payment
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class V1PaymentToPaymentConverter : Converter<V1Payment, Payment> {
    override fun convert(source: V1Payment): Payment {
        return Payment(
            source.userId,
            source.payerId,
            source.wishListId,
            source.productId,
            source.payment
        )
    }

    fun convertList(source: List<V1Payment>): List<Payment> {
        return source.stream().map { event -> convert(event) }.collect(Collectors.toList())
    }
}