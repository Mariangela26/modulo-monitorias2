package com.pragma.store.chapter.application.mapper;

import com.pragma.store.chapter.application.dto.SupplyRequest;
import com.pragma.store.chapter.domain.model.Seat;
import com.pragma.store.chapter.domain.model.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SupplyRequestMapper {

    Supply toSupply(SupplyRequest supplyRequest);

    //@Mapping(source = "supplyRequest.")
    //Seat toSeat(SupplyRequest supplyRequest);
}
