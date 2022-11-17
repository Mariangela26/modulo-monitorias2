package com.pragma.store.chapter.domain.model;

public class ProductSupply {
    private Long id;
    private Long productId;
    private Long supplyId;
    private Long quantity;

    public ProductSupply(Long id, Long productId, Long supplyId, Long quantity) {
        this.id = id;
        this.productId = productId;
        this.supplyId = supplyId;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(Long supplyId) {
        this.supplyId = supplyId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
