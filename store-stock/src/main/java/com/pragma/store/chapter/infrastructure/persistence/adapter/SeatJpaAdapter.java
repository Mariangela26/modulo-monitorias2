package com.pragma.store.chapter.infrastructure.persistence.adapter;

import com.pragma.store.chapter.domain.model.Seat;
import com.pragma.store.chapter.domain.spi.ISeatPersistencePort;
import com.pragma.store.chapter.infrastructure.exception.NoDataFoundException;
import com.pragma.store.chapter.infrastructure.persistence.entity.SeatEntity;
import com.pragma.store.chapter.infrastructure.persistence.mapper.SeatEntityMapper;
import com.pragma.store.chapter.infrastructure.persistence.repository.ISeatRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SeatJpaAdapter implements ISeatPersistencePort {

    private final ISeatRepository seatRepository;

    private final SeatEntityMapper seatEntityMapper;

    @Override
    public Seat saveSeat(Seat seat) {
        SeatEntity seatEntity = seatRepository.save(seatEntityMapper.toEntity(seat));
        return seatEntityMapper.toSeat(seatEntity);
    }

    @Override
    public List<Seat> getAllSeat() {
        List<SeatEntity> seatEntityList = seatRepository.findAll();
        if(seatEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return seatEntityMapper.toSeatList(seatEntityList);
    }

    @Override
    public Seat getSeat(Long seatId) {
        if(!seatRepository.findById(seatId).isPresent()){

        }
        return seatEntityMapper.toSeat(seatRepository.findById(seatId).orElseThrow());
    }

    @Override
    public void updateSeat(Seat seat) {
        seatRepository.save(seatEntityMapper.toEntity(seat));
    }

    @Override
    public void deleteSeat(Long seatId) {
        seatRepository.deleteById(seatId);
    }
}
