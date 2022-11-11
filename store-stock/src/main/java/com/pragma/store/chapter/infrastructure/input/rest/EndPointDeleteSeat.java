package com.pragma.store.chapter.infrastructure.input.rest;

import com.pragma.store.chapter.application.handler.ISeatHandler;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seat")
@RequiredArgsConstructor
public class EndPointDeleteSeat {

    private final ISeatHandler seatHandler;

    @Operation(summary = "Delete a seat by their Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Seat deleted", content = @Content),
            @ApiResponse(responseCode = "400", description = "Seat not found", content = @Content)
    })

    @DeleteMapping("/{seatId}")
    public ResponseEntity<Void> deleteSeat(@PathVariable Long seatId){
        seatHandler.deleteSeat(seatId);
        return ResponseEntity.noContent().build();
    }
}
