package com.pragma.store.chapter.infrastructure.persistence.adapter;

import com.pragma.store.chapter.domain.model.Supply;
import com.pragma.store.chapter.domain.spi.ISupplyPersistencePort;
import com.pragma.store.chapter.infrastructure.exception.NoDataFoundException;
import com.pragma.store.chapter.infrastructure.persistence.entity.SupplyEntity;
import com.pragma.store.chapter.infrastructure.persistence.mapper.SupplyEntityMapper;
import com.pragma.store.chapter.infrastructure.persistence.repository.ISupplyRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SupplyJpaAdapter implements ISupplyPersistencePort {

    private final ISupplyRepository supplyRepository;
    private final SupplyEntityMapper supplyEntityMapper;
    @Override
    public Supply saveSupply(Supply supply) {
        SupplyEntity supplyEntity = supplyRepository.save(supplyEntityMapper.toEntity(supply));
        return supplyEntityMapper.toSupply(supplyEntity);
    }

    @Override
    public List<Supply> getAllSupply() {
        return null;
    }

    @Override
    public Supply getSupply(Long supplyId) {
        return supplyEntityMapper.toSupply(supplyRepository.findById(supplyId).orElseThrow(NoDataFoundException::new));
    }

    @Override
    public void updateSupply(Supply supply) {

    }

    @Override
    public void deleteSupply(Long supply) {

    }
}
