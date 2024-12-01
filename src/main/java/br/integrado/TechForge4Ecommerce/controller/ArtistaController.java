package br.integrado.TechForge4Ecommerce.controller;

import br.integrado.TechForge4Ecommerce.model.Artista;
import br.integrado.TechForge4Ecommerce.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/artista")
public class ArtistaController {

    @Autowired
    private ArtistaRepository repository;
    @GetMapping
    public List<Artista> findAll(){
        return this.repository.findAll();

    }

}
