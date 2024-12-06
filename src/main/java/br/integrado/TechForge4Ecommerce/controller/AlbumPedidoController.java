package br.integrado.TechForge4Ecommerce.controller;


import br.integrado.TechForge4Ecommerce.model.AlbumPedido;
import br.integrado.TechForge4Ecommerce.repository.AlbumPedidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/album-pedido")
public class AlbumPedidoController {

    private final AlbumPedidoRepository albumPedidoRepository;

    public AlbumPedidoController(AlbumPedidoRepository albumPedidoRepository) {
        this.albumPedidoRepository = albumPedidoRepository;
    }

    @GetMapping
    public ResponseEntity<List<AlbumPedido>> listarTodos() {
        List<AlbumPedido> albumPedidos = albumPedidoRepository.findAll();
        return ResponseEntity.ok(albumPedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumPedido> buscarPorId(@PathVariable Integer id) {
        Optional<AlbumPedido> albumPedido = albumPedidoRepository.findById(id);
        return albumPedido.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AlbumPedido> criar(@RequestBody AlbumPedido albumPedido) {
        AlbumPedido novoAlbumPedido = albumPedidoRepository.save(albumPedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAlbumPedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbumPedido> atualizar(@PathVariable Integer id, @RequestBody AlbumPedido albumPedidoAtualizado) {
        Optional<AlbumPedido> albumPedidoExistente = albumPedidoRepository.findById(id);
        if (albumPedidoExistente.isPresent()) {
            AlbumPedido albumPedido = albumPedidoExistente.get();
            albumPedido.setPedido(albumPedidoAtualizado.getPedido());
            albumPedido.setAlbum(albumPedidoAtualizado.getAlbum());
            albumPedido.setQuantidade(albumPedidoAtualizado.getQuantidade());
            AlbumPedido albumPedidoSalvo = albumPedidoRepository.save(albumPedido);
            return ResponseEntity.ok(albumPedidoSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (albumPedidoRepository.existsById(id)) {
            albumPedidoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
