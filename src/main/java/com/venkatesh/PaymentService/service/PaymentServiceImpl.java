package com.venkatesh.PaymentService.service;

import com.venkatesh.PaymentService.entity.TransactionDetails;
import com.venkatesh.PaymentService.model.PaymentRequest;
import com.venkatesh.PaymentService.repository.TransactionDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;
    @Override
    public long doPayment(PaymentRequest paymentRequest) {
        TransactionDetails transactionDetails=TransactionDetails
                .builder()
                .orderId(paymentRequest.getOrderId())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .paymentDate(Instant.now())
                .paymentStatus("SUCCESS")
                .amount(paymentRequest.getAmount())
                .build();
        transactionDetailsRepository.save(transactionDetails);
        return transactionDetails.getId();
    }
}
