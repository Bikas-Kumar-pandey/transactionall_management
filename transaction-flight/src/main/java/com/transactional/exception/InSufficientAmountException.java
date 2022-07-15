package com.transactional.exception;

public class InSufficientAmountException extends RuntimeException{

    public  InSufficientAmountException(String msg){
        super(msg);
    }

}
