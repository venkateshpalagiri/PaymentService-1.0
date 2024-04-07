package com.venkatesh.PaymentService.service;

import com.venkatesh.PaymentService.model.PaymentRequest;
import com.venkatesh.PaymentService.model.PaymentResponse;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);
    PaymentResponse getPaymentDetails(long id);
}
