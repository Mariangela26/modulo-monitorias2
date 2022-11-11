package com.pragma.store.chapter.application.mapper;

import com.pragma.store.chapter.application.dto.SeatRequest;
import com.pragma.store.chapter.domain.model.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SeatRequestMapper {

    Seat toSeat(SeatRequest seatRequest);

}
