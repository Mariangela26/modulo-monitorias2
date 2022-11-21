package com.pragma.store.chapter.application.dto;

import com.pragma.store.chapter.domain.model.ProductSupply;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SupplyResponse {
    private Date date;
    private SeatDto seat;
    private Long providerId;
    private Long dispatcherId;
    private List<ProductSupply> productSupplies;
}
