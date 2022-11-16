package com.pragma.store.chapter.domain.spi;

import com.pragma.store.chapter.domain.model.Dispatcher;
import com.pragma.store.chapter.domain.model.Provider;

import java.util.List;

public interface IPersonClientPersistencePort {
    Provider getProvider(Long providerId);
    List<Provider> getAllProvider();

    Dispatcher getEmployee(Long providerId);
    List<Dispatcher> getAllDispatcher();
}
