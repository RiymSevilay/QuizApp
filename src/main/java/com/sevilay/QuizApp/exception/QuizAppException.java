package com.sevilay.QuizApp.exception;

import lombok.Getter;


@Getter
public class QuizAppException extends RuntimeException {

    private final ErrorType errorType;
    public QuizAppException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }

    public QuizAppException(ErrorType errorType, String message){
        super(message);
        this.errorType=errorType;
    }
}
