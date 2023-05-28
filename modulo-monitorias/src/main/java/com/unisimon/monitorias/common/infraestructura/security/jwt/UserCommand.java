package com.unisimon.monitorias.common.infraestructura.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCommand {

    String id;
    String email;
    String apellidos;
    String name;

    @JsonProperty("cognito:groups")
    List<String> tipoUsuario;

    @JsonProperty("identities")
    List<Identidad> identidad;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Identidad {

        @JsonProperty("userId")
        String usuarioId;
    }

/*    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public static class Persona {
        @JsonProperty("medatada")
        List<String> data;
        //@SerializedName("familyName")
        @JsonProperty("familyName")
        String apellido;
        //@SerializedName("givenName")
        @JsonProperty("givenName")
        String nombre;
    }*/

}
