package com.pragma.store.chapter.domain.api;

import com.pragma.store.chapter.domain.model.Dispatcher;
import com.pragma.store.chapter.domain.model.Provider;

import java.util.List;

public interface IPersonClientServicePort {
    Provider getProvider(Long providerId);
    List<Provider> getAllProvider();

    Dispatcher getDispatcher(Long dispatcherId);
    List<Dispatcher> getAllDispatcher();
}
