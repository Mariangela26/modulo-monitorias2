package com.pragma.store.chapter.infrastructure.output.feign.mapper;

import com.pragma.store.chapter.application.dto.DispatcherResponse;
import com.pragma.store.chapter.domain.model.Dispatcher;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface DispatcherMapper {
    Dispatcher toDispatcher(DispatcherResponse dispatcherResponse);
}
