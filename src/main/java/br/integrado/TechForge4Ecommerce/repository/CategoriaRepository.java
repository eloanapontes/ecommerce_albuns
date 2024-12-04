package br.integrado.TechForge4Ecommerce.repository;

import br.integrado.TechForge4Ecommerce.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
