package com.pragma.store.chapter.application.handler;

import com.pragma.store.chapter.application.dto.*;
import com.pragma.store.chapter.application.mapper.*;
import com.pragma.store.chapter.domain.api.IPersonClientServicePort;
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

    //clients
    private final IPersonClientServicePort personClientServicePort;

    @Override
    public SupplyResponse saveSupply(SupplyRequest supplyRequest) {
        SeatDto seatDto = seatDtoMapper.toDto(seatServicePort.getSeat(supplyRequest.getSeatId()));
        ProviderDto providerDto = providerDtoMapper.toDto(personClientServicePort.getProvider(supplyRequest.getProviderId()));
        EmployeeDto employeeDto = employeeDtoMapper.toDto(personClientServicePort.getEmployee(supplyRequest.getEmployeeId()));

        Supply supply = supplyServicePort.saveSupply(supplyRequestMapper.toSupply(supplyRequest));
        return supplyResponseMapper.toResponse(supply, seatDto, providerDto, employeeDto);
    }

    @Override
    public List<SupplyResponse> getAllSupply() {
        return supplyResponseMapper.toResponseList(supplyServicePort.getAllSupply(), seatServicePort.getAllSeat(), personClientServicePort.getAllProvider(), personClientServicePort.getAllDispatcher());
        //return null;
    }

    @Override
    public SupplyResponse getSupply(Long supplyId) {
        Supply supply = supplyServicePort.getSupply(supplyId);
        return supplyResponseMapper.toResponse(
                supply,
                seatDtoMapper.toDto(seatServicePort.getSeat(supply.getSeat().getId())),
                providerDtoMapper.toDto(personClientServicePort.getProvider(supply.getProvider().getId())),
                employeeDtoMapper.toDto(personClientServicePort.getEmployee(supply.getEmployee().getId()))
        );
    }

    @Override
    public void updateSupply(SupplyRequest supplyRequest, Long supplyId) {
        //TODO: para pensar. Necesitaria otro tipo de Request y que se actualice la lista de ProductSuppliers
        //Supply oldSupply = supplyServicePort.getSupply(supplyId);
        //Seat newSeat = seatServicePort.getSeat(supplyRequest.getSeatId());
        //newSeat.set
    }

    @Override
    public void deleteSupply(Long supplyId) {
        Supply supply = supplyServicePort.getSupply(supplyId);
        //TODO: para otro ticket, eliminar los Product Supplies
        supplyServicePort.deleteSupply(supplyId);
    }
}
