package com.pragma.store.chapter.application.mapper;

import com.pragma.store.chapter.application.dto.ProductSupplyDto;
import com.pragma.store.chapter.domain.model.ProductSupply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductSupplyDtoMapper {
    ProductSupplyDto toDto(ProductSupply productSupply);

    //ProductSupply toProductSupply(ProductSupplyDto productSupplyDto);

    //se mappea productId y quantity
    List<ProductSupply> toProductSupplyList(List<ProductSupplyDto> productSuppliesDto);
}
