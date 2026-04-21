package com.healthsys.pacientes.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario-service", url = "http://servico-usuarios:8084")
public interface UsuarioClient {

    @GetMapping(value = "/usuario/{id}")
    Object buscarUsuario(@PathVariable("id") Long id);
}
