package org.projetoverdinho.projetoverdinhoapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteController {
    @PostMapping("/")
    public String teste(){
        return "SERVER CONNECTION IS OK";
    }
}
