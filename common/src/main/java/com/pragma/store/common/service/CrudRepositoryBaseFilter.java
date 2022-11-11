package com.pragma.store.common.service;


import com.pragma.store.common.filter.BaseFilter;
import com.pragma.store.common.persistence.Model;

import java.util.stream.Stream;


public interface CrudRepositoryBaseFilter<ID, MODELO extends Model<ID>, FILTRO extends BaseFilter> {

    MODELO save(MODELO modelo);

    Stream<MODELO> save(Iterable<MODELO> modelo);

    void update(MODELO modelo);

    void update(Iterable<MODELO> modelo);

    void update(ID id, MODELO modelo);

    void deleteById(ID id);

    void deleteById(Iterable<ID> id);

    void delete(MODELO modelo);

    MODELO findById(ID id);

    Stream<MODELO> findById(Iterable<ID> id);

    Stream<MODELO> getAll(FILTRO filtro);

}
