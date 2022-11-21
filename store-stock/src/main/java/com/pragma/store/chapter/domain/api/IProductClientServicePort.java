package com.pragma.store.chapter.domain.api;

import org.springframework.http.ResponseEntity;

public interface IProductClientServicePort {
    ResponseEntity getProduct(Long productId);
}
