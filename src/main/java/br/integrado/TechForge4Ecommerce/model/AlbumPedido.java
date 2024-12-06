package br.integrado.TechForge4Ecommerce.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Album_Pedido")
public class AlbumPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_album_pedido")
    private Integer idAlbumPedido;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_album", nullable = false)
    private Album album;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    public Integer getIdAlbumPedido() {
        return idAlbumPedido;
    }

    public void setIdAlbumPedido(Integer idAlbumPedido) {
        this.idAlbumPedido = idAlbumPedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
