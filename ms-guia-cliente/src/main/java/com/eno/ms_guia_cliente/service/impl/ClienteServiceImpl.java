package com.eno.ms_guia_cliente.service.impl;

import com.eno.ms_guia_cliente.entity.Cliente;
import com.eno.ms_guia_cliente.repository.ClienteRepository;
import com.eno.ms_guia_cliente.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Long id, Cliente cliente) {
        return clienteRepository.findById(id)
                .map(c -> {
                    c.setNombre(cliente.getNombre());
                    c.setEmail(cliente.getEmail());
                    c.setTelefono(cliente.getTelefono());
                    c.setDireccion(cliente.getDireccion());
                    return clienteRepository.save(c);
                })
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
