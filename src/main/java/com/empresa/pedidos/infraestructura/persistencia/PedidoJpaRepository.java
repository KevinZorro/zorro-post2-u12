package com.empresa.pedidos.infraestructura.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoJpaRepository extends JpaRepository<PedidoEntidad, Long> {
}
