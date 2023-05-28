package com.unisimon.monitorias.common.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectResponse<T> extends BaseResponse implements Serializable {
    private T data;

    public ObjectResponse(T data) {
        this(HttpStatus.OK, data);
    }

    public ObjectResponse(String mensaje, T data) {
        super(mensaje);
        this.data = data;
    }

    public ObjectResponse(@NotNull HttpStatus status, T data) {
        super(status.getReasonPhrase());
        this.data = data;
    }

    public ObjectResponse(HttpStatus status, String mensaje, T data) {
        super(mensaje);
        this.data = data;
    }

}
