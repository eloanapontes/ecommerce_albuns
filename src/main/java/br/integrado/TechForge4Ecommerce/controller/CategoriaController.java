package br.integrado.TechForge4Ecommerce.controller;

import br.integrado.TechForge4Ecommerce.model.Categoria;
import br.integrado.TechForge4Ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaRepository repository;
    @GetMapping
    public List<Categoria> findAll(){
        return this.repository.findAll();
    }



}
