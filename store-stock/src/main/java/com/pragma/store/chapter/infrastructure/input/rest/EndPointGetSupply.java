package com.pragma.store.chapter.infrastructure.input.rest;

import com.pragma.store.chapter.application.dto.SupplyResponse;
import com.pragma.store.chapter.application.handler.ISupplyHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supply")
@RequiredArgsConstructor
public class EndPointGetSupply {
    private final ISupplyHandler supplyHandler;

    @Operation(summary = "Get a supply by their id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Supply found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = SupplyResponse.class))),
            @ApiResponse(responseCode = "404", description = "Supply not found", content = @Content)
    })
    @GetMapping("/{supplyId}")
    public ResponseEntity<SupplyResponse> getSupply(@Parameter(description = "Id of the supply to be returned")
                                                @PathVariable(name = "supplyId") Long supplyId){
        return ResponseEntity.ok(supplyHandler.getSupply(supplyId));
    }
}