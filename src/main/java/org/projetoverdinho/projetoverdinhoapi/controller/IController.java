package org.projetoverdinho.projetoverdinhoapi.controller;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IController<T> {
    ResponseEntity adiciona(T i, String secretKey);

    ResponseEntity buscaTodos(String secretKey);

    ResponseEntity buscaPorId(Long id, String secretKey);

    ResponseEntity editaPorId(Long id, Map<String, String> updates, String secretKey);

    ResponseEntity deletePorId(Long id, String secretKey);
}
