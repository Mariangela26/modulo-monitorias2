package com.pragma.store.chapter.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SupplyResponse {
    private Date date;
    private SeatDto seat;
    private ProviderDto provider;
    private DispatcherDto dispatcher;
    //mapear employee despues
}
