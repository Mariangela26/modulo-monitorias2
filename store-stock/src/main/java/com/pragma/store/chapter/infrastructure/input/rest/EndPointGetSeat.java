package com.pragma.store.chapter.infrastructure.input.rest;

import com.pragma.store.chapter.application.dto.SeatResponse;
import com.pragma.store.chapter.application.handler.ISeatHandler;
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
@RequestMapping("/seat")
@RequiredArgsConstructor
public class EndPointGetSeat {

    private final ISeatHandler seatHandler;

    @Operation(summary = "Get a seat by their id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Seat found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = SeatResponse.class))),
            @ApiResponse(responseCode = "404", description = "Seat not found", content = @Content)
    })
    @GetMapping("/{seatId}")
    public ResponseEntity<SeatResponse> getSeat(@Parameter(description = "Id of the seat to be returned")
                                                @PathVariable(name = "seatId") Long seatId){
        return ResponseEntity.ok(seatHandler.getSeat(seatId));
    }
}
