package com.pragma.store.chapter.infrastructure.output.feign.adapter;

import com.pragma.store.chapter.application.dto.DispatcherResponse;
import com.pragma.store.chapter.application.dto.ProviderResponse;
import com.pragma.store.chapter.domain.api.IPersonClientServicePort;
import com.pragma.store.chapter.domain.model.Dispatcher;
import com.pragma.store.chapter.domain.model.Provider;
import com.pragma.store.chapter.infrastructure.output.feign.PersonFeignClient;
import com.pragma.store.chapter.infrastructure.output.feign.mapper.DispatcherMapper;
import com.pragma.store.chapter.infrastructure.output.feign.mapper.ProviderMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequiredArgsConstructor
public class PersonClientAdapter implements IPersonClientServicePort {

    //inyectar el cliente
    private final PersonFeignClient personFeignClient;
    private final ProviderMapper providerMapper;
    private final DispatcherMapper dispatcherMapper;

    @Override
    public Provider getProvider(Long providerId) {
        try{
            ResponseEntity<ProviderResponse> response = personFeignClient.getProvider(providerId);
            return providerMapper.toProvider(response.getBody());
        } catch (FeignException e) {
            throw e;
        }
    }

    @Override
    public List<Provider> getAllProvider() {
        return null;
    }

    @Override
    public Dispatcher getDispatcher(Long dispatcherId) {
        try{
            ResponseEntity<DispatcherResponse> response = personFeignClient.getDispatcher(dispatcherId);
            return dispatcherMapper.toDispatcher(response.getBody());
        } catch (FeignException e) {
            throw e;
        }
    }

    @Override
    public List<Dispatcher> getAllDispatcher() {
        return null;
    }
}
