package com.team.bloom.favoriz.controller

import com.team.bloom.favoriz.controller.model.V1Payment
import com.team.bloom.favoriz.converter.V1PaymentToPaymentConverter
import com.team.bloom.favoriz.service.PaymentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/users/{userId}")
class PayController() {
    @Autowired
    private lateinit var payementService: PaymentService
    @Autowired
    private lateinit var converter: V1PaymentToPaymentConverter

    @PostMapping("/pay")
    fun pay(@PathVariable userId: Long, @RequestBody payment: V1Payment) {
        payementService.pay(converter.convert(payment))
    }
}
