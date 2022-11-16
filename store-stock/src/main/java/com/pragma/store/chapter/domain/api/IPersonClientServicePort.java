package com.pragma.store.chapter.domain.api;

import com.pragma.store.chapter.domain.model.Dispatcher;
import com.pragma.store.chapter.domain.model.Provider;

public interface IPersonClientServicePort {
    Provider getProvider(Long providerId);
    Dispatcher getEmployee(Long providerId);
}
