package com.pragma.store.chapter.infrastructure.output.feign.mapper;

import com.pragma.store.chapter.application.dto.ProviderResponse;
import com.pragma.store.chapter.domain.model.Provider;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ProviderMapper {
    Provider toProvider(ProviderResponse providerResponse);
}
