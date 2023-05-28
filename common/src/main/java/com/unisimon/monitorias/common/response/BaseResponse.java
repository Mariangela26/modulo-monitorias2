package com.unisimon.monitorias.common.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse implements Serializable {

    private String message;

    public static BaseResponse ok(String mensaje) {
        return new BaseResponse(mensaje);
    }

}
