package com.pragma.store.chapter.application.handler;

import com.pragma.store.chapter.application.dto.ProductSupplyDto;

public interface IProductSupplyHandler {

    ProductSupplyDto getProductSupply(Long productSupplyId);
}
