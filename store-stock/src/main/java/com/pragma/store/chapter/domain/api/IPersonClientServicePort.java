package com.pragma.store.chapter.domain.api;

public interface IPersonClientServicePort {
    Object getProvider(Long providerId);
    //List<Provider> getAllProvider();

    Object getDispatcher(Long dispatcherId);
    //List<Dispatcher> getAllDispatcher();
}
