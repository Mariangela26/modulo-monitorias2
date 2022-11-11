package com.pragma.store.chapter.infrastructure.exceptionHandler;

public enum ExceptionResponse {

    SEAT_NOT_FOUND("No Seat was found with that number"),
    SEAT_ALREADY_EXISTS("There is already a Seat with that number"),
    NO_DATA_FOUND("No data found for the requested petition");

    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
