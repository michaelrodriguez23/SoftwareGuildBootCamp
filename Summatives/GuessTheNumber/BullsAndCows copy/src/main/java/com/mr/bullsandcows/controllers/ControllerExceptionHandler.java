/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.bullsandcows.controllers;

import com.mr.bullsandcows.service.GameNotFoundException;
import com.mr.bullsandcows.service.InvalidGameException;
import java.sql.SQLIntegrityConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author michaelrodriguez
 */
@ControllerAdvice
@RestController
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
 
    private static final String CONSTRAINT_SAVE_MESSAGE = "Could not save your game. "
            + "Please ensure it is valid and try again."; 
    
    
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class) // this is the class of the exception
    // its only going to handle sqlintegrity exception
    public final ResponseEntity<Error> handleSqlException(
            SQLIntegrityConstraintViolationException ex, //
            WebRequest request) {
        
        Error err = new Error();
        err.setMessage("Looks like theres something wrong writing to the Database, check the rules, and check your input dude"); // 
        return new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);

    }
    
    @ExceptionHandler(GameNotFoundException.class)
    public final ResponseEntity<Error> handleGameNotFoundException(
            GameNotFoundException ex,
            WebRequest request) {
        Error err = new Error();
        err.setMessage(ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
     @ExceptionHandler(InvalidGameException.class)
    public final ResponseEntity<Error> InvalidGameException(
            GameNotFoundException ex,
            WebRequest request) {
        Error err = new Error();
        err.setMessage(ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
 
            
}
