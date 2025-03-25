package org.projetoverdinho.projetoverdinhoapi.Infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;


// Essa porra server como filtro excessões é legal mais chato pra caralho de configurar
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    
    /*
    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<Map<String, Object>> EnumNotFound(HttpMessageNotReadableException exception){
        Map<String,Object> response = new HashMap<>();
        response.put("status","error");
        response.put("message",exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }*/

}
