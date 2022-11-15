package com.pragma.store.chapter.domain.api;

import com.pragma.store.chapter.domain.model.Seat;

import java.util.List;

public interface ISeatServicePort {

    Seat saveSeat(Seat seat);

    List<Seat> getAllSeat();

    Seat getSeat(Long seatId);

    void updateSeat(Seat seat);

    void  deleteSeat(Long seat);

}
