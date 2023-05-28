package com.unisimon.monitorias.chapter.infrastructure.exceptionHandler;

import com.unisimon.monitorias.chapter.infrastructure.exception.ElementAlreadyExistsException;
import com.unisimon.monitorias.chapter.infrastructure.exception.ElementNotFoundException;
import com.unisimon.monitorias.chapter.infrastructure.exception.NoDataFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "Message";

    @ExceptionHandler(ElementAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleElementExistsException(
            ElementAlreadyExistsException elementAlreadyExistsException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.ELEMENT_ALREADY_EXISTS.getMessage()));
    }

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<Map<String, String>>handleElementNotFoundException(
            ElementNotFoundException elementNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.ELEMENT_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            NoDataFoundException noDataFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    }

}
