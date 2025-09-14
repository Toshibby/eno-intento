package com.eno.ms_guia_pedido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsGuiaPedidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGuiaPedidoApplication.class, args);
	}

}
