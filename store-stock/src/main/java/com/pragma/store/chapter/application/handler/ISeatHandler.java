package com.pragma.store.chapter.application.handler;

import com.pragma.store.chapter.application.dto.SeatRequest;
import com.pragma.store.chapter.application.dto.SeatResponse;

import java.util.List;

public interface ISeatHandler {

    void saveSeat(SeatRequest seatRequest);

    List<SeatResponse> getAllSeat();

    SeatResponse getSeat(Long seatId);

    void updateSeat(SeatRequest seatRequest, Long seatId);

    void deleteSeat(Long seatId);
}
