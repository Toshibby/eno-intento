package com.eno.ms_guia_cliente.service;

import com.eno.ms_guia_cliente.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> listarClientes();
    Optional<Cliente> obtenerClientePorId(Long id);
    Cliente guardarCliente(Cliente cliente);
    Cliente actualizarCliente(Long id, Cliente cliente);
    void eliminarCliente(Long id);
}
