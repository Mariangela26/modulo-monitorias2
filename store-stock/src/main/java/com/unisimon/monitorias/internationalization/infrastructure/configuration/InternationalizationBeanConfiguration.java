package com.unisimon.monitorias.internationalization.infrastructure.configuration;

import com.unisimon.monitorias.internationalization.aplication.handler.HandlerGetMessage;
import com.unisimon.monitorias.internationalization.domain.repository.InternationalizationRepository;
import com.unisimon.monitorias.internationalization.domain.useCase.InternationalizationUseCase;
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
