package com.pragma.store.chapter.infrastructure.input.rest;

import com.pragma.store.chapter.application.dto.SupplyRequest;
import com.pragma.store.chapter.application.handler.ISupplyHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supply")
@RequiredArgsConstructor
public class EndpointPostSupply {

    private final ISupplyHandler supplyHandler;

    @Operation(summary = "Add a new supply")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Supply created", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveSupply(@RequestBody SupplyRequest supplyRequest){
        supplyHandler.saveSupply(supplyRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
