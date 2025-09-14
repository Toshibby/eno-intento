package com.eno.ms_guia_pedido.service.impl;

import com.eno.ms_guia_pedido.entity.Pedido;
import com.eno.ms_guia_pedido.repository.PedidoRepository;
import com.eno.ms_guia_pedido.service.PedidoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> obtenerPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido guardarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido actualizarPedido(Long id, Pedido pedido) {
        return pedidoRepository.findById(id)
                .map(p -> {
                    p.setIdCliente(pedido.getIdCliente());
                    p.setIdProducto(pedido.getIdProducto());
                    p.setCantidad(pedido.getCantidad());
                    p.setTotal(pedido.getTotal());
                    p.setFecha(pedido.getFecha());
                    return pedidoRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    @Override
    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
