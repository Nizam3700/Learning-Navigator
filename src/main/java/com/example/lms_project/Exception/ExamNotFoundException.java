package com.example.lms_project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.lms_project.GlobalException.ExceptionHandler;

public class ExamNotFoundException extends RuntimeException {
    public ExamNotFoundException(String message) {
        super(message);
    }

}
