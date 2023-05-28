package com.unisimon.monitorias.common.infraestructura.error;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
@Log4j2
public class HandlerError extends ResponseEntityExceptionHandler {

    private static final String ERROR_SERVER = "Contact the administrator.";
    private static final ConcurrentHashMap<String, Integer> CODE_STATE = new ConcurrentHashMap<>();

    public HandlerError() {
        CODE_STATE.put(
                EnumNotFound.class.getSimpleName(), HttpStatus.BAD_REQUEST.value()
        );
        CODE_STATE.put(
                FilterNoValid.class.getSimpleName(), HttpStatus.BAD_REQUEST.value()
        );
        CODE_STATE.put(
                ChapterIdInvalid.class.getSimpleName(), HttpStatus.BAD_REQUEST.value()
        );
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
        ResponseEntity<Error> result;

        String excepcionName = exception.getClass().getSimpleName();
        String message = exception.getMessage();
        Integer code = CODE_STATE.get(excepcionName);

        log.error(exception.getMessage(), exception);

        if (code != null) {
            Error error = new Error(excepcionName, message);
            result = new ResponseEntity<>(error, HttpStatus.valueOf(code));
        }
        else {
            Error error = new Error(excepcionName, ERROR_SERVER);
            result = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }

}
