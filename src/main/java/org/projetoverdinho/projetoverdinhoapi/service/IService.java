package org.projetoverdinho.projetoverdinhoapi.service;

import java.util.List;

public interface IService<T> {
    T add(T t);

    T remove(String id);

    T update(String id, Object param, Object newValue);

    List<T> listAll();

    T getById(String id);
}
