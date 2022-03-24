package com.jordan.programa.resources.exception.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.jordan.programa.resources.exception.StandardError;
import com.jordan.programa.services.exception.ObjectNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> HandlerStandardError(ObjectNotFoundException ex,
            HttpServletRequest request) {

        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
