package org.projetoverdinho.projetoverdinhoapi.controller;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserController controller;



    @PostMapping
    public String create(){
        return null;
    }

    @GetMapping
    public String list(){
        return null;
    }

    @PutMapping
    public  String update(){
        return null;
    }

    @DeleteMapping
    public String delete(){
        return null;
    }
}
