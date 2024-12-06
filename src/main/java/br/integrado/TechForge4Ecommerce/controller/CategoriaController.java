package br.integrado.TechForge4Ecommerce.controller;

import br.integrado.TechForge4Ecommerce.model.Categoria;
import br.integrado.TechForge4Ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public List<Categoria> findAll() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
        Optional<Categoria> categoria = repository.findById(id);
        return categoria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return repository.save(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Integer id, @RequestBody Categoria categoriaDetails) {
        return repository.findById(id)
                .map(categoria -> {
                    categoria.setNome_categoria(categoriaDetails.getNome_categoria());
                    Categoria updatedCategoria = repository.save(categoria);
                    return ResponseEntity.ok(updatedCategoria);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Integer id) {
        Optional<Categoria> categoria = repository.findById(id);
        if (categoria.isPresent()) {
            repository.delete(categoria.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build(); // Caso a categoria não seja encontrada
        }
    }

}
