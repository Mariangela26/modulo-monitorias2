package com.pragma.store.chapter.application.mapper;

import com.pragma.store.chapter.application.dto.SupplyResponse;
import com.pragma.store.chapter.domain.model.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SupplyResponseMapper {

    SeatDtoMapper INSTANCE_SEAT = Mappers.getMapper(SeatDtoMapper.class);
    //ProviderDtoMapper INSTANCE_PROVIDER = Mappers.getMapper(ProviderDtoMapper.class);
    //DispatcherDtoMapper INSTANCE_DISPATCHER = Mappers.getMapper(DispatcherDtoMapper.class);

    SupplyResponse toResponse(Supply supply);

    //List<SupplyResponse> toResponseList(List<Supply> supplyList);

    //agregar providerList despues
    /*default List<SupplyResponse> toResponseList(List<Supply> supplyList){
        return supplyList.stream()
                .map(supply -> {
                    SupplyResponse supplyResponse = new SupplyResponse();
                    supplyResponse.setDate(supply.getDate());
                    supplyResponse.setDispatcherId(supply.getDispatcherId());
                    supplyResponse.setProviderId(supply.getProviderId());
                    supplyResponse.setSeat(INSTANCE_SEAT.toDto(seatList.stream().filter(seat -> seat.getId().equals(supply.getSeat().getId())).findFirst().orElse(null)));
                    //supplyResponse.setProvider(INSTANCE_PROVIDER.toDto(providerList.stream().filter(provider -> provider.getId().equals(supply.getProvider().getId())).findFirst().orElse(null)));
                    //supplyResponse.setDispatcher(INSTANCE_DISPATCHER.toDto(dispatcherList.stream().filter(dispatcher -> dispatcher.getId().equals(supply.getDispatcher().getId())).findFirst().orElse(null)));
                    return supplyResponse;
                }).collect(Collectors.toList());
    }*/
}
