package com.cheeses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.cheeses.model.Cheese;
import com.cheeses.repository.CheeseRepository;

@RestController
@RequestMapping("/cheeses")
public class CheeseController {
    
    // Injeção de dependência, isso vem lá do repositório cheese
    @Autowired
    private CheeseRepository cheeseRepository;

    // método para listar os nossos queijos
    @GetMapping("/")
    public List<Cheese> listCheeses(){
        return(List<Cheese>) cheeseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cheese> getCheese(@PathVariable Long id) {
        return cheeseRepository.findById(id);
    }

    @PostMapping("/")
    public void addCheese(@RequestBody Cheese cheese) {
        cheeseRepository.save(cheese);
    }

    @PutMapping("/{id}")
    public void updateCheese(@PathVariable Long id, @RequestBody Cheese cheese) {
        cheese.setId(id);
        cheeseRepository.save(cheese);
    }

    @DeleteMapping("/{id}")
    public void deleteCheese(@PathVariable Long id) {
        cheeseRepository.deleteById(id);
    }

}
