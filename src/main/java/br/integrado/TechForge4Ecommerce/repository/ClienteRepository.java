package br.integrado.TechForge4Ecommerce.repository;

import br.integrado.TechForge4Ecommerce.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
