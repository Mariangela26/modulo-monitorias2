package com.pragma.store.chapter.domain.usecase;

import com.pragma.store.chapter.domain.api.IProductSupplyServicePort;
import com.pragma.store.chapter.domain.model.ProductSupply;
import com.pragma.store.chapter.domain.spi.IProductSupplyPersistencePort;

import java.util.List;

public class ProductSupplyUseCase implements IProductSupplyServicePort {
    private final IProductSupplyPersistencePort productSupplyPersistencePort;

    public ProductSupplyUseCase(IProductSupplyPersistencePort productSupplyPersistencePort) {
        this.productSupplyPersistencePort = productSupplyPersistencePort;
    }

    @Override
    public ProductSupply saveProductSupply(ProductSupply productSupply) {
        return productSupplyPersistencePort.saveProductSupply(productSupply);
    }

    @Override
    public List<ProductSupply> getAllProductSupply() {
        return productSupplyPersistencePort.getAllProductSupply();
    }

    @Override
    public ProductSupply getProductSupply(Long productSupplyId) {
        return productSupplyPersistencePort.getProductSupply(productSupplyId);
    }

    @Override
    public void updateProductSupply(ProductSupply productSupply) {
        productSupplyPersistencePort.updateProductSupply(productSupply);
    }

    @Override
    public void deleteProductSupply(Long productSupplyId) {
        productSupplyPersistencePort.deleteProductSupply(productSupplyId);
    }
}
