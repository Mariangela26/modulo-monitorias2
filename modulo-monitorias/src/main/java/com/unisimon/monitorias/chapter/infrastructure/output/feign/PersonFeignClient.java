package com.unisimon.monitorias.chapter.infrastructure.output.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(name = "store-person", url = "localhost:8080")
public interface PersonFeignClient {

    /*@GetMapping("/provider")
    public ResponseEntity<List<ProviderResponse>> getAllProvider();

    @GetMapping("/provider/{providerId}")
    public ResponseEntity<ProviderResponse> getProvider(@PathVariable Long providerId);

    @GetMapping("/dispatcher")
    public ResponseEntity<List<DispatcherResponse>> getAllDispatcher();

    @GetMapping("/dispatcher/{dispatcherId}")
    public ResponseEntity<DispatcherResponse> getDispatcher(@PathVariable Long dispatcherId);
    */
}

