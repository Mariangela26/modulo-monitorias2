package com.unisimon.monitorias.internationalization.infrastructure.persistence.repositoryImpl;

import com.unisimon.monitorias.internationalization.domain.repository.InternationalizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;

import java.util.Locale;

@Repository
@AllArgsConstructor
public class RepositoryInternationalizationImpl implements InternationalizationRepository {

    private final MessageSource messageSource;

    @Override
    public String getMessage(String message, Locale locale) {
        return messageSource.getMessage(message, null, locale);
    }
}
