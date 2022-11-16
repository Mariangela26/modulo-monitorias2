package com.pragma.store.chapter.application.mapper;

import com.pragma.store.chapter.application.dto.ProviderDto;
import com.pragma.store.chapter.domain.model.Provider;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", //tratamos el mapper como un bean
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProviderDtoMapper {

    ProviderDto toDto(Provider provider);
}
