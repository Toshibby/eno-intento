package com.eno.ms_guia_pedido.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private Long idCliente;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
}
