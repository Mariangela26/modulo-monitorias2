package com.pragma.store.chapter.application.mapper;

import com.pragma.store.chapter.application.dto.EmployeeDto;
import com.pragma.store.chapter.application.dto.ProviderDto;
import com.pragma.store.chapter.application.dto.SeatDto;
import com.pragma.store.chapter.application.dto.SupplyResponse;
import com.pragma.store.chapter.domain.model.Dispatcher;
import com.pragma.store.chapter.domain.model.Provider;
import com.pragma.store.chapter.domain.model.Seat;
import com.pragma.store.chapter.domain.model.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SupplyResponseMapper {

    SeatDtoMapper INSTANCE_SEAT = Mappers.getMapper(SeatDtoMapper.class);
    ProviderDtoMapper INSTANCE_PROVIDER = Mappers.getMapper(ProviderDtoMapper.class);
    EmployeeDtoMapper INSTANCE_EMPLOYEE = Mappers.getMapper(EmployeeDtoMapper.class);


    @Mapping(target = "seat.name", source = "seatDto.name")
    @Mapping(target = "seat.address", source = "seatDto.address")
    @Mapping(target = "provider.city", source = "providerDto.city")
    @Mapping(target = "provider.country", source = "providerDto.country")
    @Mapping(target = "provider.addressMain", source = "providerDto.addressMain")
    @Mapping(target = "employee.enterpriseEmail", source = "employeeDto.enterpriseEmail")
    @Mapping(target = "employee.country", source = "employeeDto.country")
    @Mapping(target = "employee.city", source = "employeeDto.city")
    SupplyResponse toResponse(Supply supply, SeatDto seatDto, ProviderDto providerDto, EmployeeDto employeeDto);

    //agregar providerList despues
    default List<SupplyResponse> toResponseList(List<Supply> supplyList, List<Seat> seatList, List<Provider> providerList, List<Dispatcher> employeeList){
        return supplyList.stream()
                .map(supply -> {
                    SupplyResponse supplyResponse = new SupplyResponse();
                    supplyResponse.setDate(supply.getDate());
                    supplyResponse.setSeat(INSTANCE_SEAT.toDto(seatList.stream().filter(seat -> seat.getId().equals(supply.getSeat().getId())).findFirst().orElse(null)));
                    supplyResponse.setProvider(INSTANCE_PROVIDER.toDto(providerList.stream().filter(provider -> provider.getId().equals(supply.getProvider().getId())).findFirst().orElse(null)));
                    supplyResponse.setEmployee(INSTANCE_EMPLOYEE.toDto(employeeList.stream().filter(employee -> employee.getId().equals(supply.getEmployee().getId())).findFirst().orElse(null)));
                    return supplyResponse;
                }).collect(Collectors.toList());
    }
}
