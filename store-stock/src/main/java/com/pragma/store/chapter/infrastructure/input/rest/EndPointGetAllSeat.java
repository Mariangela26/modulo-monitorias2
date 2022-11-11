package com.pragma.store.chapter.infrastructure.input.rest;

import com.pragma.store.chapter.application.dto.SeatResponse;
import com.pragma.store.chapter.application.handler.ISeatHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seat")
@RequiredArgsConstructor
public class EndPointGetAllSeat {

    private final ISeatHandler seatHandler;

    @Operation(summary = "Get all the seats")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All seats returned",
            content = @Content(mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = SeatResponse.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<SeatResponse>> getAllSeat(){
        return ResponseEntity.ok(seatHandler.getAllSeat());
    }
}
