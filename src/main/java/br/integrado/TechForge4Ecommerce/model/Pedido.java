package br.integrado.TechForge4Ecommerce.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Integer id_pedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlbumPedido> albuns;

    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "data_pedido", nullable = false)
    private LocalDateTime dataPedido;

    // Getters e Setters
    public Integer getIdPedido() {
        return id_pedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.id_pedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<AlbumPedido> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(List<AlbumPedido> albuns) {
        this.albuns = albuns;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }
}
