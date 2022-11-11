package com.pragma.store.common.persistence;

public interface IdEntity<ID> {

    public interface Attributes {
        String ID = "id";
    }

    ID getId();

    void setId(ID id);
}
