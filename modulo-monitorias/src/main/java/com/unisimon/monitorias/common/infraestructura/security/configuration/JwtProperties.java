package com.unisimon.monitorias.common.infraestructura.security.configuration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "jwt")
@RequiredArgsConstructor
@Getter
@Setter
public class JwtProperties {

    private String secretKey;
    private String prefix;
    private Integer expiraInDays;

}
