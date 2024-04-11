package com.venkatesh.PaymentService.service;

import com.venkatesh.PaymentService.entity.TransactionDetails;
import com.venkatesh.PaymentService.exception.PaymentServiceCustomException;
import com.venkatesh.PaymentService.model.PaymentRequest;
import com.venkatesh.PaymentService.model.PaymentResponse;
import com.venkatesh.PaymentService.repository.TransactionDetailsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Random;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;
    @Override
    public long doPayment(PaymentRequest paymentRequest) {
        Random random=new Random();
        long referenceNumberGenerator=random.nextLong();
        if(referenceNumberGenerator<0){
            referenceNumberGenerator=referenceNumberGenerator*(-1);
        }

        log.info("doPayment method called in PaymentServiceImpl with payload:{}",paymentRequest);
        TransactionDetails transactionDetails=TransactionDetails
                .builder()
                .orderId(paymentRequest.getOrderId())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .referenceNumber(referenceNumberGenerator)
                .paymentDate(Instant.now())
                .paymentStatus("SUCCESS")
                .amount(paymentRequest.getAmount())
                .build();
        log.info("Transaction details created in PaymentServiceImpl with:{}",transactionDetails);
        transactionDetailsRepository.save(transactionDetails);
        log.info("doPayment method executed in PaymentServiceImpl successfully");
        return transactionDetails.getId();
    }
    @Override
    public PaymentResponse getPaymentDetails(long id){
        TransactionDetails transactionDetails=transactionDetailsRepository.findById(id)
                .orElseThrow(()->new PaymentServiceCustomException("Not found transaction with id"));
        PaymentResponse paymentResponse=new PaymentResponse();
        BeanUtils.copyProperties(transactionDetails,paymentResponse);
        return paymentResponse;
    }
}
