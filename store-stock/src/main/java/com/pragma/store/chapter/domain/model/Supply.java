package com.pragma.store.chapter.domain.model;

import java.util.Date;
import java.util.List;

public class Supply {
    private Long id;
    private Date date;
    //private Seat seat;
    private Long seatId;
    private Long dispatcherId;
    private Long providerId;
    //private Dispatcher dispatcher;
    //private Provider provider;
    private List<ProductSupply> productSupplies;

    public Supply(Long id, Date date, Long seatId, Long dispatcherId, Long providerId, List<ProductSupply> productSupplies) {
        this.id = id;
        this.date = date;
        this.seatId = seatId;
        this.dispatcherId = dispatcherId;
        this.providerId = providerId;
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

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public Long getDispatcherId() {
        return dispatcherId;
    }

    public void setDispatcherId(Long dispatcherId) {
        this.dispatcherId = dispatcherId;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public List<ProductSupply> getProductSupplies() {
        return productSupplies;
    }

    public void setProductSupplies(List<ProductSupply> productSupplies) {
        this.productSupplies = productSupplies;
    }
}
