package com.venkatesh.PaymentService.exception;

import com.venkatesh.PaymentService.model.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class RestResponseEntityCustomException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PaymentServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handlePaymentServiceCustomException(
            PaymentServiceCustomException paymentServiceCustomException
    ){
        ErrorResponse errorResponse=ErrorResponse
                .builder()
                .message(paymentServiceCustomException.getMessage())
                .errorCode(paymentServiceCustomException.getErrorCode())
                .build();
        return ResponseEntity.status(404).body(errorResponse);
    }
}
