//package org.projetoverdinho.projetoverdinhoapi.controller;
//
//import org.projetoverdinho.projetoverdinhoapi.dto.MultaAnimalDTO;
//import org.projetoverdinho.projetoverdinhoapi.entity.MultaAnimalModel;
//import org.projetoverdinho.projetoverdinhoapi.service.MultaAnimalService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/multas-animais")
//public class MultaAnimalController {
//
//    @Autowired
//    private MultaAnimalService multaAnimalService;
//
//    @PostMapping
//    public MultaAnimalModel add(@RequestBody MultaAnimalDTO multaAnimalDTO) {
//        return multaAnimalService.addMultaToAnimal(multaAnimalDTO);
//    }
//
//    @GetMapping
//    public List<MultaAnimalModel> listAll() {
//        return multaAnimalService.listAll();
//    }
//
//    @GetMapping("/{id}")
//    public MultaAnimalModel getById(@PathVariable Long id) {
//        return multaAnimalService.getById(id);
//    }
//
//    @PutMapping("/{id}")
//    public MultaAnimalModel update(@PathVariable Long id, @RequestBody Map<String, String> updates) {
//        return multaAnimalService.update(id, updates);
//    }
//
//    @DeleteMapping("/{id}")
//    public MultaAnimalModel remove(@PathVariable Long id) {
//        return multaAnimalService.remove(id);
//    }
//}
