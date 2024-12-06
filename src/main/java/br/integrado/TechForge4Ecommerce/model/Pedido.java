package br.integrado.TechForge4Ecommerce.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer idPedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido")
    private List<AlbumPedido> albuns;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "status")
    private String status;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
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

    public BigDecimal  getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal  valorTotal) {
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
