package com.unisimon.monitorias.common.infraestructura.error;

public class Error {

    private final String nameExcepcion;
    private final String message;

    public Error(String nameExcepcion, String message) {
        this.nameExcepcion = nameExcepcion;
        this.message = message;
    }

    public String getNameExcepcion() {
        return nameExcepcion;
    }

    public String getMessage() {
        return message;
    }

}

