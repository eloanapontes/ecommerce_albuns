package br.integrado.TechForge4Ecommerce.controller;

import br.integrado.TechForge4Ecommerce.model.Album;
import br.integrado.TechForge4Ecommerce.model.Artista;
import br.integrado.TechForge4Ecommerce.model.Categoria;
import br.integrado.TechForge4Ecommerce.repository.AlbumRepository;
import br.integrado.TechForge4Ecommerce.repository.ArtistaRepository;
import br.integrado.TechForge4Ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/album")
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ArtistaRepository artistaRepository;

    @GetMapping
    public ResponseEntity<List<Album>> findAll() {
        List<Album> albuns = albumRepository.findAll();
        return ResponseEntity.ok(albuns);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> findById(@PathVariable Integer id) {
        return albumRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Album> createAlbum(@RequestBody Album albumRequest) {
        Categoria categoria = categoriaRepository.findById(albumRequest.getId_categoria().getId_categoria())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        Artista artista = artistaRepository.findById(albumRequest.getId_artista().getIdArtista())
                .orElseThrow(() -> new RuntimeException("Artista não encontrado"));

        Album album = new Album();
        album.setNome(albumRequest.getNome());
        album.setDescricao(albumRequest.getDescricao());
        album.setValor(albumRequest.getValor());
        album.setQuantidade(albumRequest.getQuantidade());
        album.setId_categoria(categoria);
        album.setId_artista(artista);

        Album savedAlbum = albumRepository.save(album);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedAlbum);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable Integer id, @RequestBody Album albumDetails) {
        return albumRepository.findById(id)
                .map(album -> {
                    album.setNome(albumDetails.getNome());
                    album.setDescricao(albumDetails.getDescricao());
                    album.setId_categoria(albumDetails.getId_categoria());
                    album.setId_artista(albumDetails.getId_artista());
                    album.setValor(albumDetails.getValor());
                    album.setQuantidade(albumDetails.getQuantidade());
                    Album updatedAlbum = albumRepository.save(album);
                    return ResponseEntity.ok(updatedAlbum);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Integer id) {
        if (albumRepository.existsById(id)) {
            albumRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
