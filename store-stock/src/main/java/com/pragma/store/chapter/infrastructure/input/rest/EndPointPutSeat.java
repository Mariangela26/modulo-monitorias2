package com.pragma.store.chapter.infrastructure.input.rest;

import com.pragma.store.chapter.application.dto.SeatRequest;
import com.pragma.store.chapter.application.handler.ISeatHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seat")
@RequiredArgsConstructor
public class EndPointPutSeat {

    private final ISeatHandler seatHandler;

    @Operation(summary = "Update an existing seat")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Seat updated", content = @Content),
            @ApiResponse(responseCode = "404", description = "Seat not found", content = @Content)
    })
    @PutMapping("/{seatId}")
    public ResponseEntity<Void> updateSeat(@RequestBody SeatRequest seatRequest,
                                           @Parameter(description = "Id of the seat to be modified")
                                           @PathVariable(name = "seatId")Long seatId){
        seatHandler.updateSeat(seatRequest, seatId);
        return ResponseEntity.noContent().build();
    }
}
