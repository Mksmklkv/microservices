package com.programmingtechie.productservice.dto.mapper;

public interface Mapper<T, Q, S> {
    T toModel (Q q);

    S toDto (T t);
}
