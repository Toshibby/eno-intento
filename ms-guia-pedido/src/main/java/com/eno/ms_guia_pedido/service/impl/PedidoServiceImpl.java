package com.eno.ms_guia_pedido.service.impl;

import com.eno.ms_guia_pedido.dto.ClienteDTO;
import com.eno.ms_guia_pedido.dto.PedidoDTO;
import com.eno.ms_guia_pedido.dto.ProductoDTO;
import com.eno.ms_guia_pedido.entity.Pedido;
import com.eno.ms_guia_pedido.feign.ClienteFeign;
import com.eno.ms_guia_pedido.feign.ProductoFeign;
import com.eno.ms_guia_pedido.repository.PedidoRepository;
import com.eno.ms_guia_pedido.service.PedidoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService { // cambiado

    private final PedidoRepository pedidoRepository; // cambiado
    private final ClienteFeign clienteFeign; // cambiado
    private final ProductoFeign productoFeign; // cambiado

    public PedidoServiceImpl(PedidoRepository pedidoRepository,
                             ClienteFeign clienteFeign,
                             ProductoFeign productoFeign) { // cambiado
        this.pedidoRepository = pedidoRepository; // cambiado
        this.clienteFeign = clienteFeign; // cambiado
        this.productoFeign = productoFeign; // cambiado
    }

    // Método para convertir entidad a DTO y llenar datos remotos // cambiado
    private PedidoDTO mapToDTO(Pedido pedido) { // cambiado
        PedidoDTO dto = new PedidoDTO(); // cambiado
        dto.setIdPedido(pedido.getIdPedido()); // cambiado
        dto.setIdCliente(pedido.getIdCliente()); // cambiado
        dto.setIdProducto(pedido.getIdProducto()); // cambiado
        dto.setCantidad(pedido.getCantidad()); // cambiado
        dto.setTotal(pedido.getTotal()); // cambiado
        dto.setFecha(pedido.getFecha()); // cambiado

        // Llamadas a microservicios remotos // cambiado
        ClienteDTO cliente = clienteFeign.buscarPorId(pedido.getIdCliente()); // cambiado
        ProductoDTO producto = productoFeign.buscarPorId(pedido.getIdProducto()); // cambiado

        dto.setClienteDTO(cliente); // cambiado
        dto.setProductoDTO(producto); // cambiado

        return dto; // cambiado
    }

    // Método para convertir DTO a entidad // cambiado
    private Pedido mapToEntity(PedidoDTO dto) { // cambiado
        Pedido pedido = new Pedido(); // cambiado
        pedido.setIdPedido(dto.getIdPedido()); // cambiado
        pedido.setIdCliente(dto.getIdCliente()); // cambiado
        pedido.setIdProducto(dto.getIdProducto()); // cambiado
        pedido.setCantidad(dto.getCantidad()); // cambiado
        pedido.setTotal(dto.getTotal()); // cambiado
        pedido.setFecha(dto.getFecha()); // cambiado
        return pedido; // cambiado
    }

    @Override
    public List<PedidoDTO> listarPedidos() { // cambiado
        return pedidoRepository.findAll()
                .stream()
                .map(this::mapToDTO) // cambiado
                .collect(Collectors.toList()); // cambiado
    }

    @Override
    public Optional<PedidoDTO> obtenerPedidoPorId(Long id) { // cambiado
        return pedidoRepository.findById(id)
                .map(this::mapToDTO); // cambiado
    }

    @Override
    public PedidoDTO guardarPedido(PedidoDTO pedidoDTO) { // cambiado
        Pedido pedido = mapToEntity(pedidoDTO); // cambiado
        Pedido guardado = pedidoRepository.save(pedido); // cambiado
        return mapToDTO(guardado); // cambiado
    }

    @Override
    public PedidoDTO actualizarPedido(Long id, PedidoDTO pedidoDTO) { // cambiado
        Pedido actualizado = pedidoRepository.findById(id)
                .map(p -> {
                    p.setIdCliente(pedidoDTO.getIdCliente()); // cambiado
                    p.setIdProducto(pedidoDTO.getIdProducto()); // cambiado
                    p.setCantidad(pedidoDTO.getCantidad()); // cambiado
                    p.setTotal(pedidoDTO.getTotal()); // cambiado
                    p.setFecha(pedidoDTO.getFecha()); // cambiado
                    return pedidoRepository.save(p); // cambiado
                })
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado")); // cambiado
        return mapToDTO(actualizado); // cambiado
    }

    @Override
    public void eliminarPedido(Long id) { // cambiado
        pedidoRepository.deleteById(id); // cambiado
    }
}
