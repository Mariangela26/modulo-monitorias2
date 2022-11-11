package com.pragma.store.common.service;


import com.pragma.store.common.persistence.Model;

import java.util.stream.Stream;


public interface CrudRepositoryBase<ID, MODELO extends Model<ID>> {

    MODELO guardar(MODELO modelo);

    Stream<MODELO> guardar(Iterable<MODELO> modelo);

    void actualizar(MODELO modelo);

    void actualizar(Iterable<MODELO> modelo);

    void actualizar(ID id, MODELO modelo);

    void eliminarPorId(ID id);

    void eliminarPorId(Iterable<ID> id);

    void delete(MODELO modelo);

    MODELO buscarPorId(ID id);

    Stream<MODELO> buscarPorId(Iterable<ID> id);

    Stream<MODELO> buscarTodo();

}
