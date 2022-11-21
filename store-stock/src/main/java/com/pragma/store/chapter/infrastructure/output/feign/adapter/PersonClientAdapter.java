package com.pragma.store.chapter.infrastructure.output.feign.adapter;

import com.pragma.store.chapter.domain.api.IPersonClientServicePort;
import com.pragma.store.chapter.infrastructure.output.feign.PersonFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public class PersonClientAdapter /*implements IPersonClientServicePort*/ {

    //inyectar el cliente
    private final PersonFeignClient personFeignClient;
    //private final ProviderMapper providerMapper;
    //private final DispatcherMapper dispatcherMapper;

    /*@Override
    public Object getProvider(Long providerId) {
        try{
            ResponseEntity response = personFeignClient.getProvider(providerId);
            return providerMapper.toProvider(response.getBody());
        } catch (FeignException e) {
            throw e;
        }
    }


    @Override
    public Dispatcher getDispatcher(Long dispatcherId) {
        try{
            ResponseEntity<DispatcherResponse> response = personFeignClient.getDispatcher(dispatcherId);
            return dispatcherMapper.toDispatcher(response.getBody());
        } catch (FeignException e) {
            throw e;
        }
    }*/

}
