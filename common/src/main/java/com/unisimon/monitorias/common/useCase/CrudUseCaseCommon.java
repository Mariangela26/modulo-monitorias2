package com.unisimon.monitorias.common.useCase;

import com.unisimon.monitorias.common.persistence.Model;
import com.unisimon.monitorias.common.service.CrudRepositoryBase;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public class CrudUseCaseCommon<REPOSITORIO extends CrudRepositoryBase<ID, ENTIDAD>, ENTIDAD extends Model<ID>, ID> {

    private final REPOSITORIO repositorio;

    public ENTIDAD guardar(ENTIDAD entidad) {
        return repositorio.guardar(entidad);
    }

    public void actualizar(ENTIDAD entidad) {
        repositorio.actualizar(entidad);
    }

    public ENTIDAD obtenerPorId(ID id) {
        return repositorio.buscarPorId(id);
    }

    public Stream<ENTIDAD> obtenerTodos() {
        return repositorio.buscarTodo();
    }

    public void eliminarPorId(ID id) {
        repositorio.eliminarPorId(id);
    }
}
