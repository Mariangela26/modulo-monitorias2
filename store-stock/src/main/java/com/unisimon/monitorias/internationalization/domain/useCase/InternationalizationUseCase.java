package com.unisimon.monitorias.internationalization.domain.useCase;

import com.unisimon.monitorias.internationalization.domain.repository.InternationalizationRepository;
import lombok.RequiredArgsConstructor;

import java.util.Locale;

@RequiredArgsConstructor
public class InternationalizationUseCase {

    private final InternationalizationRepository internationalizationRepository;

    public String getMessage(String message, Locale locale){
        return internationalizationRepository.getMessage(message, locale);
    }
}
