package com.sevilay.QuizApp.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ErrorType {

    QUESTION_NOT_FOUND(1001,"Girdiğiniz soru bulunamamaktadır.",HttpStatus.NOT_FOUND),
    AT_LEAST_TWO_OPTION(1002,"Her sorunun en az 2 cevabı olmalıdır.",HttpStatus.BAD_REQUEST),
    BAD_REQUEST_ERROR(3001,"BAD REQUEST", HttpStatus.BAD_REQUEST),
    NO_QUESTION_FOUND(1003,"Hiç soru bulunamadı." ,HttpStatus.NOT_FOUND );

    private int code;
    private  String message;
    private HttpStatus httpStatus;

}
