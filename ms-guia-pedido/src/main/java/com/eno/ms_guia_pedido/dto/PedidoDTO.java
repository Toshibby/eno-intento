package com.eno.ms_guia_pedido.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private Long idPedido;
    private Long idCliente;
    private Long idProducto;
    private Integer cantidad;
    private BigDecimal total;
    private LocalDateTime fecha;

    // Relación a DTOs
    private ClienteDTO clienteDTO;
    private ProductoDTO productoDTO;
}
