package com.pragma.store.internationalization.aplication.handler;

import com.pragma.store.internationalization.domain.useCase.InternationalizationUseCase;
import lombok.RequiredArgsConstructor;

import java.util.Locale;

@RequiredArgsConstructor
public class HandlerGetMessage {

    private final InternationalizationUseCase internationalizationUseCase;

    public String getMessage(String message, Locale locale){
        return internationalizationUseCase.getMessage(message, locale);
    }
}
