package com.pragma.store.chapter.infrastructure.input.rest;

import com.pragma.store.chapter.application.dto.SeatRequest;
import com.pragma.store.chapter.application.dto.SeatResponse;
import com.pragma.store.chapter.application.handler.ISeatHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seat")
@RequiredArgsConstructor
public class EndPointPostSeat {

    private final ISeatHandler seatHandler;

    @Operation(summary = "Add a new seat")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Seat created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Seat already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveSeat(@RequestBody SeatRequest seatRequest){
        seatHandler.saveSeat(seatRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
