package com.eno.ms_guia_pedido.feign;

import com.eno.ms_guia_pedido.dto.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ms-guia-cliente", path = "/clientes")
public interface ClienteFeign {
    @GetMapping("/{id}")
    public ClienteDTO buscarPorId(@PathVariable Long id);
}
