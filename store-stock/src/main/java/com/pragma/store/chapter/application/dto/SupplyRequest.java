package com.pragma.store.chapter.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SupplyRequest {
    private Long dispatcherId;
    private Long seatId;
    private Long providerId;
    private Date date;
    private ProductSupplyDto[] productSupplies;
}
