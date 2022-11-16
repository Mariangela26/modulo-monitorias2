package com.pragma.store.chapter.application.handler;

import com.pragma.store.chapter.application.dto.ProviderDto;
import com.pragma.store.chapter.application.dto.SeatDto;
import com.pragma.store.chapter.application.dto.SupplyRequest;
import com.pragma.store.chapter.application.dto.SupplyResponse;
import com.pragma.store.chapter.application.mapper.*;
import com.pragma.store.chapter.domain.api.ISeatServicePort;
import com.pragma.store.chapter.domain.api.ISupplyServicePort;
import com.pragma.store.chapter.domain.model.Seat;
import com.pragma.store.chapter.domain.model.Supply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SupplyHandler implements ISupplyHandler {

    private final ISupplyServicePort supplyServicePort;
    private final ISeatServicePort seatServicePort;
    //providerService
    //(employee) dispatcherService
    private final SupplyRequestMapper supplyRequestMapper;
    private final SupplyResponseMapper supplyResponseMapper;
    private final SeatDtoMapper seatDtoMapper;
    private final EmployeeDtoMapper employeeDtoMapper;
    private final ProviderDtoMapper providerDtoMapper;

    @Override
    public SupplyResponse saveSupply(SupplyRequest supplyRequest) {
        SeatDto seatDto = seatDtoMapper.toDto(seatServicePort.getSeat(supplyRequest.getSeatId()));
        //ProviderDto providerDto = providerDtoMapper.toDto()

        //Supply supply = supplyServicePort.saveSupply(supplyRequestMapper.toSupply(supplyRequest));
        //return supplyResponseMapper.toResponse(supply);
        return null;
    }

    @Override
    public List<SupplyResponse> getAllSupply() {
        return null;
    }

    @Override
    public SupplyResponse getSupply(Long supplyId) {
        return null;
    }

    @Override
    public void updateSupply(SupplyRequest supplyRequest, Long supplyId) {

    }

    @Override
    public void deleteSupply(Long supplyId) {

    }
}
