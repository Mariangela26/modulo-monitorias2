package com.pragma.store.chapter.application.mapper;

import com.pragma.store.chapter.application.dto.ProductSupplyDto;
import com.pragma.store.chapter.domain.model.ProductSupply;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductSupplyDtoMapper {
    ProductSupplyDto toDto(ProductSupply productSupply);
    ProductSupply toProductSupply(ProductSupplyDto productSupplyDto);
}
