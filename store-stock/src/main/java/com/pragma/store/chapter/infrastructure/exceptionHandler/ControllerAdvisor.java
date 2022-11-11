package com.pragma.store.chapter.infrastructure.exceptionHandler;

import com.pragma.store.chapter.infrastructure.exception.NoDataFoundException;
import com.pragma.store.chapter.infrastructure.exception.SeatAlreadyExistsException;
import com.pragma.store.chapter.infrastructure.exception.SeatNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "Message";

    @ExceptionHandler(SeatAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleSeatAlreadyExistsException(
            SeatAlreadyExistsException seatAlreadyExistsException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.SEAT_ALREADY_EXISTS.getMessage()));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundExceotion(
            NoDataFoundException noDataFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    }

    @ExceptionHandler(SeatNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleSeatNotFoundException(
            SeatNotFoundException seatNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.SEAT_NOT_FOUND.getMessage()));
    }

}
