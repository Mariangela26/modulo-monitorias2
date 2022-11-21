package com.pragma.store.chapter.domain.usecase;

import com.pragma.store.chapter.domain.api.ISupplyServicePort;
import com.pragma.store.chapter.domain.model.Supply;
import com.pragma.store.chapter.domain.spi.ISupplyPersistencePort;

import java.util.List;

public class SupplyUseCase implements ISupplyServicePort {
    private final ISupplyPersistencePort supplyPersistencePort;

    public SupplyUseCase(ISupplyPersistencePort supplyPersistencePort) {
        this.supplyPersistencePort = supplyPersistencePort;
    }

    @Override
    public Supply saveSupply(Supply supply) {
        return supplyPersistencePort.saveSupply(supply);
    }

    @Override
    public List<Supply> getAllSupply() {
        return supplyPersistencePort.getAllSupply();
    }

    @Override
    public Supply getSupply(Long supplyId) {
        return supplyPersistencePort.getSupply(supplyId);
    }

    @Override
    public void updateSupply(Supply supply) {
        supplyPersistencePort.updateSupply(supply);
    }

    @Override
    public void deleteSupply(Long supplyId) {
        supplyPersistencePort.deleteSupply(supplyId);
    }
}
