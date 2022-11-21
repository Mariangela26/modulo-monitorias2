package com.pragma.store.chapter.infrastructure.persistence.mapper;

import com.pragma.store.chapter.domain.model.ProductSupply;
import com.pragma.store.chapter.infrastructure.persistence.entity.ProductSupplyEntity;
import com.pragma.store.chapter.domain.model.Supply;
import com.pragma.store.chapter.infrastructure.persistence.entity.SupplyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ProductSupplyEntityMapper {
    ProductSupplyEntity toEntity(ProductSupply productSupply);

    ProductSupply toProductSupply(ProductSupplyEntity productSupplyEntity);
}
