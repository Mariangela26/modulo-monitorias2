package com.pragma.store.common.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Named;

import java.util.stream.Stream;


public interface BaseConverter<A, B> {
    @Named("AToB")
    B leftToRight(A a);

    @Named("BToA")
    A rightToLeft(B b);

    @IterableMapping(qualifiedByName = "AToB")
    Stream<B> leftToRight(Iterable<A> left);

    @IterableMapping(qualifiedByName = "BToA")
    Stream<A> rightToLeft(Iterable<B> right);
}
