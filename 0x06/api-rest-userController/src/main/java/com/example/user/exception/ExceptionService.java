package com.example.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionService {

    @ExceptionHandler(CPFException.class)
    public ResponseEntity<CPFException> handleException(CPFException err){
        UserErrorResponse userErrorResponse = new UserErrorResponse();

        userErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        userErrorResponse.setMessage(err.getMessage());

        return new ResponseEntity(userErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserIdException.class)
    public ResponseEntity<UserIdException> handleException(UserIdException err) {
        UserErrorResponse userErrorResponse = new UserErrorResponse(HttpStatus.NOT_FOUND.value(), err.getMessage());

        return new ResponseEntity(userErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNameException.class)
    public ResponseEntity<UserNameException> handleException(UserNameException err) {
        UserErrorResponse userErrorResponse = new UserErrorResponse(HttpStatus.NOT_FOUND.value(), err.getMessage());

        return new ResponseEntity(userErrorResponse, HttpStatus.NOT_FOUND);
    }
}
