package br.integrado.TechForge4Ecommerce.model;

import jakarta.persistence.*;

@Entity //diz ao JPA que a classe vai ser tratada pelo EntityManager que vai entender que pode ser manipulada pelo JPA pra update insert e etc
@Table
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tipo id que é pk que vai gerar automaticamente
    private Integer idArtista;

    @Column
    private String nomeArtista;

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

}
