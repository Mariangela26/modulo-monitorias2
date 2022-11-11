package com.pragma.store.chapter.domain.usecase;

import com.pragma.store.chapter.domain.api.ISeatServicePort;
import com.pragma.store.chapter.domain.model.Seat;
import com.pragma.store.chapter.domain.spi.ISeatPersistencePort;

import java.util.List;

public class SeatUseCase implements ISeatServicePort {

    private final ISeatPersistencePort seatPersistencePort;

    public SeatUseCase(ISeatPersistencePort seatPersistencePort) {
        this.seatPersistencePort = seatPersistencePort;
    }


    @Override
    public void saveSeat(Seat seat) {

    }

    @Override
    public List<Seat> getAllSeat() {
        return null;
    }

    @Override
    public Seat getSeat(Long seatId) {
        return null;
    }

    @Override
    public void updateSeat(Seat seat) {

    }

    @Override
    public void deleteSeat(Seat seat) {

    }
}
