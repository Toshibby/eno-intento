package com.eno.ms_guia_pedido.service;

import com.eno.ms_guia_pedido.dto.PedidoDTO;
import com.eno.ms_guia_pedido.entity.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<PedidoDTO> listarPedidos();
    Optional<PedidoDTO> obtenerPedidoPorId(Long id);
    PedidoDTO guardarPedido(PedidoDTO pedidoDTO);
    PedidoDTO actualizarPedido(Long id, PedidoDTO pedidoDTO);
    void eliminarPedido(Long id);
}
