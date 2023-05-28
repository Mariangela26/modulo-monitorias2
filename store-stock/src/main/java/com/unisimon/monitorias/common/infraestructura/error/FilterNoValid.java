package com.unisimon.monitorias.common.infraestructura.error;

public class FilterNoValid extends RuntimeException{

    public FilterNoValid(String message){
        super(message);
    }
}
