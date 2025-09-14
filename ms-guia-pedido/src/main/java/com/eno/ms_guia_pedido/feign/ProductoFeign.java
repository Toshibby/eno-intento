package com.eno.ms_guia_pedido.feign;

import com.eno.ms_guia_pedido.dto.ClienteDTO;
import com.eno.ms_guia_pedido.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ms-guia-producto", path = "/productos")
public interface ProductoFeign {
    @GetMapping("/{id}")
    public ProductoDTO buscarPorId(@PathVariable Long id);
}
