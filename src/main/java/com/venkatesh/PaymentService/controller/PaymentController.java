package com.venkatesh.PaymentService.controller;

import com.venkatesh.PaymentService.model.PaymentRequest;
import com.venkatesh.PaymentService.model.PaymentResponse;
import com.venkatesh.PaymentService.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@Log4j2
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest){
        log.info("doPayment method called in PaymentController layer");
        return new ResponseEntity<>(paymentService.doPayment(paymentRequest), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getPaymentDetails(@PathVariable long id){
        return new ResponseEntity<>(paymentService.getPaymentDetails(id),HttpStatus.OK);
    }
}
