package com.kaplan.regimen.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InvalidUserPasswordController {
    @ExceptionHandler(value = InvalidUserPassword.class)
    public ResponseEntity<Object>exception(InvalidUserPassword exception){
        return new ResponseEntity<>("Invalid Password", HttpStatus.BAD_REQUEST);
    }
}
