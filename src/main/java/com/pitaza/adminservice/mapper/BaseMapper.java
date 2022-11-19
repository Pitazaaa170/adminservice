package com.pitaza.adminservice.mapper;

public interface BaseMapper<F,T> {

    T mapFrom(F object);
}
