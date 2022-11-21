package com.pragma.store.chapter.domain.api;

import com.pragma.store.chapter.domain.model.Supply;

import java.util.List;

public interface ISupplyServicePort {
    Supply saveSupply(Supply supply);

    List<Supply> getAllSupply();

    Supply getSupply(Long supplyId);

    void updateSupply(Supply supply);

    void deleteSupply(Long supplyId);
}
