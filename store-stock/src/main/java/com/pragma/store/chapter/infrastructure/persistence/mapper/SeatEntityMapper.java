package com.pragma.store.chapter.infrastructure.persistence.mapper;

import com.pragma.store.chapter.domain.model.Seat;
import com.pragma.store.chapter.infrastructure.persistence.entity.SeatEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SeatEntityMapper {

    SeatEntity toEntity(Seat seat);

    Seat toSeat(SeatEntity seatEntity);

    List<Seat> toSeatList(List<SeatEntity> seatEntityList);

}
