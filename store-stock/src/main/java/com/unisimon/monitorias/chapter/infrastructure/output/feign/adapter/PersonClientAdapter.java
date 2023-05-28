package com.unisimon.monitorias.chapter.infrastructure.output.feign.adapter;

import com.unisimon.monitorias.chapter.infrastructure.output.feign.PersonFeignClient;
import lombok.RequiredArgsConstructor;

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
