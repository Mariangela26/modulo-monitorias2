package com.unisimon.monitorias.internationalization.domain.repository;

import java.util.Locale;

public interface InternationalizationRepository {
    String getMessage(String message, Locale locale);
}
