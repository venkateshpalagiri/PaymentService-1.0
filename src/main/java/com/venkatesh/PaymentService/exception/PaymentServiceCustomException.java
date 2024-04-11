package com.venkatesh.PaymentService.exception;

public class PaymentServiceCustomException extends RuntimeException{

    public PaymentServiceCustomException(String message){
        super(message);
    }
}
