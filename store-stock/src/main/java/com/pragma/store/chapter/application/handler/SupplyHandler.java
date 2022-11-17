package com.pragma.store.chapter.application.handler;

import com.pragma.store.chapter.application.dto.*;
import com.pragma.store.chapter.application.mapper.*;
import com.pragma.store.chapter.domain.api.IPersonClientServicePort;
import com.pragma.store.chapter.domain.api.IProductSupplyServicePort;
import com.pragma.store.chapter.domain.api.ISeatServicePort;
import com.pragma.store.chapter.domain.api.ISupplyServicePort;
import com.pragma.store.chapter.domain.model.ProductSupply;
import com.pragma.store.chapter.domain.model.Supply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SupplyHandler implements ISupplyHandler {

    private final ISupplyServicePort supplyServicePort;
    private final ISeatServicePort seatServicePort;
    private final IProductSupplyServicePort productSupplyServicePort;
    //clients
    private final IPersonClientServicePort personClientServicePort;

    //mappers
    private final SupplyRequestMapper supplyRequestMapper;
    private final SupplyResponseMapper supplyResponseMapper;
    private final SeatDtoMapper seatDtoMapper;
    private final DispatcherDtoMapper dispatcherDtoMapper;
    private final ProviderDtoMapper providerDtoMapper;
    private final ProductSupplyDtoMapper productSupplyDtoMapper;



    @Override
    public SupplyResponse saveSupply(SupplyRequest supplyRequest) {
        List<ProductSupplyDto> productSuppliesDto = Arrays.stream(supplyRequest.getProductSupplies()).collect(Collectors.toList());
        SeatDto seatDto = seatDtoMapper.toDto(seatServicePort.getSeat(supplyRequest.getSeatId()));
        ProviderDto providerDto = providerDtoMapper.toDto(personClientServicePort.getProvider(supplyRequest.getProviderId()));
        DispatcherDto dispatcherDto = dispatcherDtoMapper.toDto(personClientServicePort.getDispatcher(supplyRequest.getDispatcherId()));
        Supply supply = supplyServicePort.saveSupply(supplyRequestMapper.toSupply(supplyRequest));

        supply.setProductSupplies(productSuppliesDto.stream()
                .map(productSupplyDtoMapper::toProductSupply)
                .map(productSupply -> {
                    productSupply.setSupplyId(supply.getId());
                    try{
                       productSupply = productSupplyServicePort.saveProductSupply(productSupply);
                    } catch () {

                    }
                    return productSupply;
                })
        );

        return supplyResponseMapper.toResponse(supply, seatDto, providerDto, dispatcherDto);
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
                dispatcherDtoMapper.toDto(personClientServicePort.getDispatcher(supply.getDispatcher().getId()))
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
