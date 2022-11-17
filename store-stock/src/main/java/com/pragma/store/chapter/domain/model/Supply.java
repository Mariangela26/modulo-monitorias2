package com.pragma.store.chapter.domain.model;

import java.util.Date;

public class Supply {
    private Long id;
    private Date date;
    private Seat seat;
    private Dispatcher dispatcher;
    private Provider provider;
    private ProductSupply[] productSupplies;

    public Supply(Long id, Date date, Seat seat, Dispatcher dispatcher, Provider provider, ProductSupply[] productSupplies) {
        this.id = id;
        this.date = date;
        this.seat = seat;
        this.dispatcher = dispatcher;
        this.provider = provider;
        this.productSupplies = productSupplies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public ProductSupply[] getProductSupplies() {
        return productSupplies;
    }

    public void setProductSupplies(ProductSupply[] productSupplies) {
        this.productSupplies = productSupplies;
    }
}
