package org.projetoverdinho.projetoverdinhoapi.controller;

import org.apache.coyote.Response;
import org.projetoverdinho.projetoverdinhoapi.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/image")
public class ImageController {

    @Autowired
    ImageService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestParam("file")MultipartFile image){
        return ResponseEntity.ok(service.save(image));
    }

}
