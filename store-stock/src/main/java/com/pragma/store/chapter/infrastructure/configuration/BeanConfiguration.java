package com.pragma.store.chapter.infrastructure.configuration;

import com.pragma.store.chapter.domain.api.ISeatServicePort;
import com.pragma.store.chapter.domain.spi.ISeatPersistencePort;
import com.pragma.store.chapter.domain.usecase.SeatUseCase;
import com.pragma.store.chapter.infrastructure.persistence.adapter.SeatJpaAdapter;
import com.pragma.store.chapter.infrastructure.persistence.mapper.SeatEntityMapper;
import com.pragma.store.chapter.infrastructure.persistence.repository.ISeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ISeatRepository seatRepository;

    private final SeatEntityMapper seatEntityMapper;

    @Bean
    public ISeatPersistencePort seatPersistencePort(){
        return new SeatJpaAdapter(seatRepository, seatEntityMapper);
    }

    @Bean
    public ISeatServicePort seatServicePort(){
        return new SeatUseCase(seatPersistencePort());
    }

}
