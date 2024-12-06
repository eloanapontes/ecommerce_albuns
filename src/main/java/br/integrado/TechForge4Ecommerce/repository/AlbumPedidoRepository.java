package br.integrado.TechForge4Ecommerce.repository;

import br.integrado.TechForge4Ecommerce.model.AlbumPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumPedidoRepository extends JpaRepository<AlbumPedido, Integer> {
}
