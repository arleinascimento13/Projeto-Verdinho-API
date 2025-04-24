package org.projetoverdinho.projetoverdinhoapi.service;

import java.util.List;
import java.util.Map;

public interface IService<T> {
    T add(T t);

    T remove(Long id);

    T update(Long id, Map<String, String> updates); // Atualização parcial

    List<T> listAll();

    T getById(Long id);
}
