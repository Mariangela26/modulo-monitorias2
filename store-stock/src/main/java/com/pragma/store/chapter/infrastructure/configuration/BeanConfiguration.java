package com.pragma.store.chapter.infrastructure.configuration;

import com.pragma.store.chapter.domain.api.IProductSupplyServicePort;
import com.pragma.store.chapter.domain.api.ISeatServicePort;
import com.pragma.store.chapter.domain.api.ISupplyServicePort;
import com.pragma.store.chapter.domain.spi.IProductSupplyPersistencePort;
import com.pragma.store.chapter.domain.spi.ISeatPersistencePort;
import com.pragma.store.chapter.domain.spi.ISupplyPersistencePort;
import com.pragma.store.chapter.domain.usecase.ProductSupplyUseCase;
import com.pragma.store.chapter.domain.usecase.SeatUseCase;
import com.pragma.store.chapter.domain.usecase.SupplyUseCase;
import com.pragma.store.chapter.infrastructure.persistence.adapter.ProductSupplyJpaAdapter;
import com.pragma.store.chapter.infrastructure.persistence.adapter.SeatJpaAdapter;
import com.pragma.store.chapter.infrastructure.persistence.adapter.SupplyJpaAdapter;
import com.pragma.store.chapter.infrastructure.persistence.mapper.ProductSupplyEntityMapper;
import com.pragma.store.chapter.infrastructure.persistence.mapper.SeatEntityMapper;
import com.pragma.store.chapter.infrastructure.persistence.mapper.SupplyEntityMapper;
import com.pragma.store.chapter.infrastructure.persistence.repository.IProductSupplyRepository;
import com.pragma.store.chapter.infrastructure.persistence.repository.ISeatRepository;
import com.pragma.store.chapter.infrastructure.persistence.repository.ISupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ISeatRepository seatRepository;
    private final ISupplyRepository supplyRepository;
    private final IProductSupplyRepository productSupplyRepository;

    private final SeatEntityMapper seatEntityMapper;
    private final SupplyEntityMapper supplyEntityMapper;
    private final ProductSupplyEntityMapper productSupplyEntityMapper;

    @Bean
    public ISeatPersistencePort seatPersistencePort(){
        return new SeatJpaAdapter(seatRepository, seatEntityMapper);
    }

    @Bean
    public ISeatServicePort seatServicePort(){
        return new SeatUseCase(seatPersistencePort());
    }

    @Bean
    public ISupplyPersistencePort supplyPersistencePort(){
        return new SupplyJpaAdapter(supplyRepository, supplyEntityMapper);
    }

    @Bean
    public ISupplyServicePort supplyServicePort(){
        return new SupplyUseCase(supplyPersistencePort());
    }

    @Bean
    public IProductSupplyPersistencePort productSupplyPersistencePort(){
        return new ProductSupplyJpaAdapter(productSupplyRepository, productSupplyEntityMapper);
    }

    @Bean
    public IProductSupplyServicePort productSupplyServicePort(){
        return new ProductSupplyUseCase(productSupplyPersistencePort());
    }

}
