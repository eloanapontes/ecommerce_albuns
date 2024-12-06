package br.integrado.TechForge4Ecommerce.repository;

import br.integrado.TechForge4Ecommerce.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

}
