package com.pragma.store.internationalization.infrastructure.configuration;

import com.pragma.store.internationalization.aplication.handler.HandlerGetMessage;
import com.pragma.store.internationalization.domain.repository.InternationalizationRepository;
import com.pragma.store.internationalization.domain.useCase.InternationalizationUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InternationalizationBeanConfiguration {

    @Bean
    public HandlerGetMessage handlerGetMessage(InternationalizationUseCase internationalizationUseCase){
        return new HandlerGetMessage(internationalizationUseCase);
    }

    @Bean
    public InternationalizationUseCase internationalizationUseCase(InternationalizationRepository internationalizationRepository){
        return new InternationalizationUseCase(internationalizationRepository);
    }
}
