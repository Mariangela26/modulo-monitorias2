package com.pragma.store.chapter.application.mapper;

import com.pragma.store.chapter.application.dto.DispatcherDto;
import com.pragma.store.chapter.domain.model.Dispatcher;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", //tratamos el mapper como un bean
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DispatcherDtoMapper {
    DispatcherDto toDto(Dispatcher dispatcher);
}
