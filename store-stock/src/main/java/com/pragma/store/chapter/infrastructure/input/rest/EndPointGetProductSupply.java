package com.pragma.store.chapter.infrastructure.input.rest;

import com.pragma.store.chapter.application.dto.ProductSupplyDto;
import com.pragma.store.chapter.application.dto.SeatResponse;
import com.pragma.store.chapter.application.handler.IProductSupplyHandler;
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
@RequestMapping("/productSupply")
@RequiredArgsConstructor
public class EndPointGetProductSupply {
    private final IProductSupplyHandler productSupplyHandler;

    @Operation(summary = "Get a product supply by their id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product supply found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductSupplyDto.class))),
            @ApiResponse(responseCode = "404", description = "Product Supply not found", content = @Content)
    })
    @GetMapping("/{productSupplyId}")
    public ResponseEntity<ProductSupplyDto> getProductSupply(@Parameter(description = "Id of the product supply to be returned")
                                                @PathVariable(name = "productSupplyId") Long productSupplyId){
        return ResponseEntity.ok(productSupplyHandler.getProductSupply(productSupplyId));
    }
}
