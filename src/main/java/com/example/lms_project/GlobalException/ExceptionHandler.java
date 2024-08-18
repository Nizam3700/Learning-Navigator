package com.example.lms_project.GlobalException;

import com.example.lms_project.Exception.CustomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<String> handleCustomNotFoundException(CustomNotFoundException elementException){
        return new ResponseEntity<String>("NO Value is present in DB, Please change your request", HttpStatus.BAD_REQUEST);
    }

}
