package com.pragma.store.chapter.application.handler;

import com.pragma.store.chapter.application.dto.*;
import com.pragma.store.chapter.application.mapper.*;
import com.pragma.store.chapter.domain.api.*;
import com.pragma.store.chapter.domain.model.ProductSupply;
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
    private final IProductSupplyServicePort productSupplyServicePort;

    //clients
    //private final IPersonClientServicePort personClientServicePort;
    //private final IProductClientServicePort productClientServicePort;

    //mappers
    private final SupplyRequestMapper supplyRequestMapper;
    private final SupplyResponseMapper supplyResponseMapper;
    private final SeatDtoMapper seatDtoMapper;
    private final ProductSupplyDtoMapper productSupplyDtoMapper;



    @Override
    public SupplyResponse saveSupply(SupplyRequest supplyRequest) {
        Supply supply = supplyRequestMapper.toSupply(supplyRequest);

        //mappear los dtos a productSupplies
        List<ProductSupplyDto> productSupplyDtos = supplyRequest.getProductSuppliesDtos();
        List<ProductSupply> productSupplies = productSupplyDtoMapper.toProductSupplyList(productSupplyDtos);

        supply.setProductSupplies(productSupplies);

        supplyServicePort.saveSupply(supply);

        return supplyResponseMapper.toResponse(supply);

        //List<ProductSupplyDto> productSuppliesDto = Arrays.stream(supplyRequest.getProductSupplies()).collect(Collectors.toList());
        //SeatDto seatDto = seatDtoMapper.toDto(seatServicePort.getSeat(supplyRequest.getSeatId()));
        //ProviderDto providerDto = providerDtoMapper.toDto(personClientServicePort.getProvider(supplyRequest.getProviderId()));
        //DispatcherDto dispatcherDto = dispatcherDtoMapper.toDto(personClientServicePort.getDispatcher(supplyRequest.getDispatcherId()));

        //validar si getDispatcher y getProvider nos dan OK (despues)




        //Supply supply = supplyServicePort.saveSupply(supplyRequestMapper.toSupply(supplyRequest));

        /*supply.setProductSupplies(productSuppliesDto.stream()
                .map(productSupplyDtoMapper::toProductSupply)
                .map(productSupply -> {
                    productSupply.setSupplyId(supply.getId());
                    try{
                        ResponseEntity product = productClientServicePort.getProduct(productSupply.getProductId());

                        if(product.getStatusCode() == HttpStatus.OK){
                            productSupply = productSupplyServicePort.saveProductSupply(productSupply);
                        }
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                    return productSupply;
                })
        );*/


    }

    @Override
    public List<SupplyResponse> getAllSupply() {
        //return supplyResponseMapper.toResponseList(supplyServicePort.getAllSupply(), seatServicePort.getAllSeat(), personClientServicePort.getAllProvider(), personClientServicePort.getAllDispatcher());
        return null;
    }

    @Override
    public SupplyResponse getSupply(Long supplyId) {
        Supply supply = supplyServicePort.getSupply(supplyId);
        return supplyResponseMapper.toResponse(supply);
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
