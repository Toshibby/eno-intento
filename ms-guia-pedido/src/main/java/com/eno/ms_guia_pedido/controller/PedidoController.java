package com.eno.ms_guia_pedido.controller;

import com.eno.ms_guia_pedido.dto.PedidoDTO; // cambiado
import com.eno.ms_guia_pedido.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController { // cambiado

    private final PedidoService pedidoService; // cambiado

    public PedidoController(PedidoService pedidoService) { // cambiado
        this.pedidoService = pedidoService; // cambiado
    }

    // Listar todos los pedidos
    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listarPedidos() { // cambiado
        List<PedidoDTO> pedidos = pedidoService.listarPedidos(); // cambiado
        return ResponseEntity.ok(pedidos); // cambiado
    }

    // Obtener un pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> obtenerPedido(@PathVariable Long id) { // cambiado
        return pedidoService.obtenerPedidoPorId(id) // cambiado
                .map(ResponseEntity::ok) // cambiado
                .orElseGet(() -> ResponseEntity.notFound().build()); // cambiado
    }

    // Crear un nuevo pedido
    @PostMapping
    public ResponseEntity<PedidoDTO> crearPedido(@RequestBody PedidoDTO pedidoDTO) { // cambiado
        PedidoDTO guardado = pedidoService.guardarPedido(pedidoDTO); // cambiado
        return ResponseEntity.ok(guardado); // cambiado
    }

    // Actualizar un pedido
    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> actualizarPedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) { // cambiado
        try {
            PedidoDTO actualizado = pedidoService.actualizarPedido(id, pedidoDTO); // cambiado
            return ResponseEntity.ok(actualizado); // cambiado
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // cambiado
        }
    }

    // Eliminar un pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) { // cambiado
        pedidoService.eliminarPedido(id); // cambiado
        return ResponseEntity.noContent().build(); // cambiado
    }
}
