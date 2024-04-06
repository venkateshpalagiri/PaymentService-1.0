package com.venkatesh.PaymentService.service;

import com.venkatesh.PaymentService.model.PaymentRequest;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);
}
