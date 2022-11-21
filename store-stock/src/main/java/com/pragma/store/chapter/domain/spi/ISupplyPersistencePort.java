package com.pragma.store.chapter.domain.spi;

import com.pragma.store.chapter.domain.model.Supply;

import java.util.List;

public interface ISupplyPersistencePort {
    Supply saveSupply(Supply supply);

    List<Supply> getAllSupply();

    Supply getSupply(Long supplyId);

    void updateSupply(Supply supply);

    void  deleteSupply(Long supply);
}
