package br.com.entregapedido.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "pedido", schema = "entrega_pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name="data_pedido", nullable = false)
    private Date dataPedido;

    @Basic
    @Column(name="data_entrega", nullable = false)
    private Date dataEntrega;

    @Basic
    @Column(name="descricao")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name = "status")
    private PedidoStatus status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Cliente.class)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(Date dataPedido, Date dataEntrega, String descricao, PedidoStatus status, Cliente cliente) {
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.descricao = descricao;
        this.status = status;
        this.cliente = cliente;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public PedidoStatus getStatus() {
        return status;
    }

    public void setStatus(PedidoStatus status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id) &&
                Objects.equals(dataPedido, pedido.dataPedido) &&
                Objects.equals(dataEntrega, pedido.dataEntrega) &&
                Objects.equals(descricao, pedido.descricao) &&
                status == pedido.status &&
                Objects.equals(cliente, pedido.cliente);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, dataPedido, dataEntrega, descricao, status, cliente);
    }
}