package com.venkatesh.PaymentService.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class RestResponseEntityCustomException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PaymentServiceCustomException.class)
    public ResponseEntity<String> handlePaymentServiceCustomException(
            PaymentServiceCustomException paymentServiceCustomException
    ){
        return ResponseEntity.status(404).body(paymentServiceCustomException.getMessage());
    }
}
