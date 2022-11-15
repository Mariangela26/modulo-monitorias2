package com.pragma.store.chapter.domain.spi;

import com.pragma.store.chapter.domain.model.Seat;

import java.util.List;

public interface ISeatPersistencePort {

    Seat saveSeat(Seat seat);

    List<Seat> getAllSeat();

    Seat getSeat(Long seatId);

    void updateSeat(Seat seat);

    void  deleteSeat(Long seat);

}
