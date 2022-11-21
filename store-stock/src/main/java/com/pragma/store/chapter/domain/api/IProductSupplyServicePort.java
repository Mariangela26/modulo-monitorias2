package com.pragma.store.chapter.domain.api;

import com.pragma.store.chapter.domain.model.ProductSupply;

import java.util.List;

public interface IProductSupplyServicePort {
    ProductSupply saveProductSupply(ProductSupply productSupply);

    List<ProductSupply> getAllProductSupply();

    ProductSupply getProductSupply(Long productSupplyId);

    void updateProductSupply(ProductSupply productSupply);

    void deleteProductSupply(Long productSupplyId);
}
