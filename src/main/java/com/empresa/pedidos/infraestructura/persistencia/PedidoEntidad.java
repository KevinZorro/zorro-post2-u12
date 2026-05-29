package com.empresa.pedidos.infraestructura.persistencia;

import com.empresa.pedidos.dominio.EstadoPedido;
import com.empresa.pedidos.dominio.Pedido;
import com.empresa.pedidos.dominio.TipoPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class PedidoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoPedido tipo;

    private double subtotal;
    private double costo;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado = EstadoPedido.CREADO;

    private String emailCliente;

    public PedidoEntidad() {
    }

    public static PedidoEntidad fromDomain(Pedido pedido) {
        PedidoEntidad entidad = new PedidoEntidad();
        entidad.id = pedido.getId();
        entidad.tipo = pedido.getTipo();
        entidad.subtotal = pedido.getSubtotal();
        entidad.costo = pedido.getCosto();
        entidad.estado = pedido.getEstado();
        entidad.emailCliente = pedido.getEmailCliente();
        return entidad;
    }

    public Pedido toDomain() {
        Pedido pedido = new Pedido();
        pedido.setId(id);
        pedido.setTipo(tipo);
        pedido.setSubtotal(subtotal);
        pedido.setCosto(costo);
        pedido.setEstado(estado);
        pedido.setEmailCliente(emailCliente);
        return pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoPedido getTipo() {
        return tipo;
    }

    public void setTipo(TipoPedido tipo) {
        this.tipo = tipo;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
}
