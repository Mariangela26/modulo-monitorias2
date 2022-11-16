package com.pragma.store.chapter.domain.spi;

import com.pragma.store.chapter.domain.model.Dispatcher;
import com.pragma.store.chapter.domain.model.Provider;

public interface IPersonClientPort {
    Provider getProvider(Long providerId);
    Dispatcher getEmployee(Long providerId);
}
