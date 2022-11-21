package com.pragma.store.chapter.application.handler;

import com.pragma.store.chapter.application.dto.SupplyRequest;
import com.pragma.store.chapter.application.dto.SupplyResponse;

import java.util.List;

public interface ISupplyHandler {
    SupplyResponse saveSupply(SupplyRequest supplyRequest);

    List<SupplyResponse> getAllSupply();

    SupplyResponse getSupply(Long supplyId);

    void updateSupply(SupplyRequest supplyRequest, Long supplyId);

    void deleteSupply(Long supplyId);
}
