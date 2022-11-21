package com.pragma.store.chapter.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SupplyRequest {
    private Date date;
    private Long seatId;
    private Long dispatcherId;
    private Long providerId;
    private List<ProductSupplyDto> productSuppliesDtos; //se maneja de manera externa
}
