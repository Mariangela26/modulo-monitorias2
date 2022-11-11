package com.pragma.store.common.service.impl;

import com.pragma.store.common.filter.BaseFilter;
import com.pragma.store.common.mapper.BaseConverter;
import com.pragma.store.common.persistence.IdEntity;
import com.pragma.store.common.persistence.Model;
import com.pragma.store.common.service.CrudRepositoryBaseFilter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;
import java.util.stream.Stream;


public abstract class CrudRepositoryBaseFilterImpl<ID, MODEL extends Model<ID>, ENTITY extends IdEntity<ID>, FILTER extends BaseFilter>
        implements CrudRepositoryBaseFilter<ID, MODEL, FILTER> {

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public MODEL save(MODEL MODEL) {
        ENTITY ENTITY = getBaseConversion().leftToRight(MODEL);
        getRespository().save(ENTITY);
        MODEL MODELResponse = getBaseConversion().rightToLeft(ENTITY);
        return MODELResponse;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Stream<MODEL> save(Iterable<MODEL> modelo) {
        Stream<ENTITY> entidades = getBaseConversion().leftToRight(modelo);
        Iterable<ENTITY> entidadesGuardadas = getRespository()
                .saveAll(entidades.collect(Collectors.toList()));
        return getBaseConversion().rightToLeft(entidadesGuardadas);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(MODEL MODEL) {
        ENTITY ENTITY = getBaseConversion().leftToRight(MODEL);
        getRespository().save(ENTITY);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Iterable<MODEL> modelo) {
        Stream<ENTITY> entidades = getBaseConversion().leftToRight(modelo);
        getRespository()
                .saveAll(entidades.collect(Collectors.toList()));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(ID id, MODEL MODEL) {
        MODEL.setId(id);
        ENTITY ENTITY = getBaseConversion().leftToRight(MODEL);
        getRespository().save(ENTITY);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(ID id) {
        getRespository().deleteById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(Iterable<ID> id) {
        Iterable<ENTITY> entidadesGuardadas = getRespository().findAllById(id);
        getRespository().deleteAll(entidadesGuardadas);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(MODEL MODEL) {
        ENTITY ENTITY = getBaseConversion().leftToRight(MODEL);
        getRespository().delete(ENTITY);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public MODEL findById(ID id) {
        ENTITY ENTITY = getRespository().findById(id).orElse(null);
        return getBaseConversion().rightToLeft(ENTITY);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Stream<MODEL> findById(Iterable<ID> id) {
        Iterable<ENTITY> entidadesGuardadas = getRespository().findAllById(id);
        return getBaseConversion().rightToLeft(entidadesGuardadas);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Stream<MODEL> getAll(FILTER FILTER) {
        return findByFilter(FILTER).map(getBaseConversion()::rightToLeft);
    }

    protected abstract CrudRepository<ENTITY, ID> getRespository();

    protected abstract BaseConverter<MODEL, ENTITY> getBaseConversion();

    protected abstract Stream<ENTITY> findByFilter(FILTER FILTER);

}
