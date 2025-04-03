package org.projetoverdinho.projetoverdinhoapi.controller;

import org.projetoverdinho.projetoverdinhoapi.dto.UserDTO;
import org.projetoverdinho.projetoverdinhoapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody UserDTO user){
        this.service.create(user);
        return ResponseEntity.ok("User has created is sucess");
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
