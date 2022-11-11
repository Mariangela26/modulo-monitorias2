package com.pragma.store.databuilder.users;

import com.pragma.store.users.domain.model.PerfilePhoto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PerfilePhotoTestDataBuilder {

    public static final String CONTENIDO = "fotoDePrueba";

    private String contenido;

    public PerfilePhotoTestDataBuilder(){
        this.contenido = CONTENIDO;
    }

    public PerfilePhoto buildPerfilePhoto(){
        return new PerfilePhoto(this.contenido);
    }
}
