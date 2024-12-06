package br.integrado.TechForge4Ecommerce.controller;

import br.integrado.TechForge4Ecommerce.model.Album;
import br.integrado.TechForge4Ecommerce.model.Cliente;
import br.integrado.TechForge4Ecommerce.model.Pedido;
import br.integrado.TechForge4Ecommerce.repository.AlbumRepository;
import br.integrado.TechForge4Ecommerce.repository.ClienteRepository;
import br.integrado.TechForge4Ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/criar")
    public ResponseEntity<?> criarPedido(
            @RequestParam Integer idCliente,
            @RequestParam Integer idAlbum,
            @RequestParam Integer quantidade) {
        try {
            Cliente cliente = clienteRepository.findById(idCliente)
                    .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));

            Album album = albumRepository.findById(idAlbum)
                    .orElseThrow(() -> new IllegalArgumentException("Álbum não encontrado."));

            Pedido pedido = new Pedido();
            pedido.setCliente(cliente);
            pedido.setStatus("Pendente");
            pedido.setDataPedido(LocalDateTime.now());
            pedido.setValorTotal(album.getValor().multiply(BigDecimal.valueOf(quantidade)));

            pedidoRepository.save(pedido);

            return ResponseEntity.ok("Pedido criado com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao criar o pedido.");
        }
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return ResponseEntity.ok(pedidos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPedidoPorId(@PathVariable Integer id) {
        var pedido = pedidoRepository.findById(id);
        if (pedido.isPresent()) {
            return ResponseEntity.ok(pedido.get());
        } else {
            return ResponseEntity.status(404).body("Pedido não encontrado.");
        }
    }

    @PutMapping("/{id}/atualizar-status")
    public ResponseEntity<?> atualizarStatus(@PathVariable Integer id, @RequestParam String novoStatus) {
        try {
            Pedido pedido = pedidoRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado."));

            pedido.setStatus(novoStatus);
            pedidoRepository.save(pedido);

            return ResponseEntity.ok("Status atualizado com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao atualizar o status.");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerPedido(@PathVariable Integer id) {
        try {
            if (!pedidoRepository.existsById(id)) {
                return ResponseEntity.status(404).body("Pedido não encontrado.");
            }
            pedidoRepository.deleteById(id);
            return ResponseEntity.ok("Pedido removido com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao remover o pedido.");
        }
    }
}
