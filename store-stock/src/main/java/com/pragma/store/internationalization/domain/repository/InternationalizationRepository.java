package com.pragma.store.internationalization.domain.repository;

import java.util.Locale;

public interface InternationalizationRepository {
    String getMessage(String message, Locale locale);
}
