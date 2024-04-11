package com.venkatesh.PaymentService.exception;

import lombok.Data;
@Data
public class PaymentServiceCustomException extends RuntimeException{
    private String errorCode;
    public PaymentServiceCustomException(String message,String errorCode){
        super(message);
        this.errorCode=errorCode;
    }

//    @Data has getters & setters
//    public String getErrorCode(){
//        return errorCode;
//    }
}
