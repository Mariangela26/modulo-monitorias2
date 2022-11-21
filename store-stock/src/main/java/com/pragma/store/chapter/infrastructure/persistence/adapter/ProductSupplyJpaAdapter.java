package com.pragma.store.chapter.infrastructure.persistence.adapter;

import com.pragma.store.chapter.domain.model.ProductSupply;
import com.pragma.store.chapter.domain.spi.IProductSupplyPersistencePort;
import com.pragma.store.chapter.infrastructure.exception.NoDataFoundException;
import com.pragma.store.chapter.infrastructure.persistence.entity.ProductSupplyEntity;
import com.pragma.store.chapter.infrastructure.persistence.mapper.ProductSupplyEntityMapper;
import com.pragma.store.chapter.infrastructure.persistence.repository.IProductSupplyRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductSupplyJpaAdapter implements IProductSupplyPersistencePort{

    private final IProductSupplyRepository productSupplyRepository;

    private final ProductSupplyEntityMapper productSupplyEntityMapper;

    @Override
    public ProductSupply saveProductSupply(ProductSupply productSupply) {
        ProductSupplyEntity productSupplyEntity = productSupplyRepository.save(productSupplyEntityMapper.toEntity(productSupply));
        return productSupplyEntityMapper.toProductSupply(productSupplyEntity);
    }

    @Override
    public List<ProductSupply> getAllProductSupply() {
        return null;
    }

    @Override
    public ProductSupply getProductSupply(Long productSupplyId) {
        return productSupplyEntityMapper.toProductSupply(productSupplyRepository.findById(productSupplyId).orElseThrow(NoDataFoundException::new));
    }

    @Override
    public void updateProductSupply(ProductSupply productSupply) {

    }

    @Override
    public void deleteProductSupply(Long productSupply) {

    }
}
