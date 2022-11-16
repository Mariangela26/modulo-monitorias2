package com.pragma.store.chapter.application.mapper;

import com.pragma.store.chapter.application.dto.SeatDto;
import com.pragma.store.chapter.domain.model.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", //tratamos el mapper como un bean
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SeatDtoMapper {

    SeatDto toDto(Seat seat);
}
