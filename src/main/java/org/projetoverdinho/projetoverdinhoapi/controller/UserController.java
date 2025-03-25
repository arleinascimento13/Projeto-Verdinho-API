package org.projetoverdinho.projetoverdinhoapi.controller;

import org.projetoverdinho.projetoverdinhoapi.dto.UserCreateDTO;
import org.projetoverdinho.projetoverdinhoapi.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService controller;

    public UserController(UserService controller){
        this.controller = controller;
    }

    @PostMapping
    public String create(@RequestBody UserCreateDTO user){
        return this.controller.create(user);
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
