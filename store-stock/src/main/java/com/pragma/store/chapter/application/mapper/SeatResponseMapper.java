package com.pragma.store.chapter.application.mapper;

import com.pragma.store.chapter.application.dto.SeatResponse;
import com.pragma.store.chapter.domain.model.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SeatResponseMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "address", source = "address")
    SeatResponse toResponse(Seat seat);

    default List<SeatResponse> toResponseList(List<Seat> seatList){
        return seatList.stream().map(seat -> {
            SeatResponse seatResponse = new SeatResponse();
            seatResponse.setName(seat.getName());
            seatResponse.setAddress(seat.getAddress());
            return seatResponse;
        }).collect(Collectors.toList());
    }
}
