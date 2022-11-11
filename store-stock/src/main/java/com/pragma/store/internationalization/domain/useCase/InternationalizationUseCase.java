package com.pragma.store.internationalization.domain.useCase;

import com.pragma.store.internationalization.domain.repository.InternationalizationRepository;
import lombok.RequiredArgsConstructor;

import java.util.Locale;

@RequiredArgsConstructor
public class InternationalizationUseCase {

    private final InternationalizationRepository internationalizationRepository;

    public String getMessage(String message, Locale locale){
        return internationalizationRepository.getMessage(message, locale);
    }
}
