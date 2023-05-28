package com.unisimon.monitorias.chapter.infrastructure.clientfeing.configuration;

import com.unisimon.monitorias.common.infraestructura.interceptor.HttpRequestContextHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {

    private String slackOauthAccessToken;

    @Bean
    public RequestInterceptor bearerTokenRequestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                template.header("Authorization", HttpRequestContextHolder.getAuthorization());
            }
        };
    }
}
