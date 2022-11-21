package com.pragma.store.chapter.application.handler;

import com.pragma.store.chapter.application.dto.ProductSupplyDto;
import com.pragma.store.chapter.application.mapper.ProductSupplyDtoMapper;
import com.pragma.store.chapter.domain.api.IProductSupplyServicePort;
import com.pragma.store.chapter.domain.model.ProductSupply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductSupplyHandler implements IProductSupplyHandler {

    private final IProductSupplyServicePort productSupplyServicePort;

    private final ProductSupplyDtoMapper productSupplyDtoMapper;

    @Override
    public ProductSupplyDto getProductSupply(Long productSupplyId) {
        ProductSupply productSupply = productSupplyServicePort.getProductSupply(productSupplyId);
        return productSupplyDtoMapper.toDto(productSupply);
    }
}
