package br.integrado.TechForge4Ecommerce.controller;

import br.integrado.TechForge4Ecommerce.model.Artista;
import br.integrado.TechForge4Ecommerce.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaRepository artistaRepository;

    @GetMapping
    public List<Artista> listarArtistas() {
        return artistaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artista> buscarArtista(@PathVariable Integer id) {
        return artistaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Artista> criarArtista(@RequestBody Artista novoArtista) {
        try {
            Artista artistaSalvo = artistaRepository.save(novoArtista);
            return ResponseEntity.ok(artistaSalvo);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artista> atualizarArtista(@PathVariable Integer id, @RequestBody Artista artistaAtualizado) {
        return artistaRepository.findById(id)
                .map(artista -> {
                    artista.setNomeArtista(artistaAtualizado.getNomeArtista()); // Atualiza o nome do artista
                    Artista artistaSalvo = artistaRepository.save(artista);
                    return ResponseEntity.ok(artistaSalvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }


}
