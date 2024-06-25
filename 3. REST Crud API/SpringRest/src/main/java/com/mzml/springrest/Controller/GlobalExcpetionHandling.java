package com.mzml.springrest.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExcpetionHandling {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        StudentErrorResponse err=new StudentErrorResponse();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(exc.getMessage());
        err.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }
}
