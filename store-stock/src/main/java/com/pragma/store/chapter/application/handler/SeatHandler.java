package com.pragma.store.chapter.application.handler;

import com.pragma.store.chapter.application.dto.SeatRequest;
import com.pragma.store.chapter.application.dto.SeatResponse;
import com.pragma.store.chapter.application.mapper.SeatRequestMapper;
import com.pragma.store.chapter.application.mapper.SeatResponseMapper;
import com.pragma.store.chapter.domain.api.ISeatServicePort;
import com.pragma.store.chapter.domain.model.Seat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SeatHandler implements ISeatHandler{

    private final ISeatServicePort seatServicePort;
    private final SeatRequestMapper seatRequestMapper;
    private final SeatResponseMapper seatResponseMapper;
    @Override
    public SeatResponse saveSeat(SeatRequest seatRequest) {
        Seat seat = seatServicePort.saveSeat(seatRequestMapper.toSeat(seatRequest));
        return seatResponseMapper.toResponse(seat);
    }

    @Override
    public List<SeatResponse> getAllSeat() {
        return seatResponseMapper.toResponseList(seatServicePort.getAllSeat());
    }

    @Override
    public SeatResponse getSeat(Long seatId) {
        Seat seat = seatServicePort.getSeat(seatId);
        return seatResponseMapper.toResponse(seat);
    }

    @Override
    public void updateSeat(SeatRequest seatRequest, Long seatId) {
        Seat oldSeat = seatServicePort.getSeat(seatId);
        Seat newSeat = seatRequestMapper.toSeat(seatRequest);
        newSeat.setId(oldSeat.getId());
        seatServicePort.updateSeat(newSeat);
    }

    @Override
    public void deleteSeat(Long seatId) {
        Seat seat = seatServicePort.getSeat(seatId);
        seatServicePort.deleteSeat(seatId);
    }
}
