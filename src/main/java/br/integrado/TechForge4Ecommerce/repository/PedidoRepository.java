package br.integrado.TechForge4Ecommerce.repository;

import br.integrado.TechForge4Ecommerce.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
