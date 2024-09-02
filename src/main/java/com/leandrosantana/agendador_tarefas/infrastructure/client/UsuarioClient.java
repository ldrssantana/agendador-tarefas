package com.leandrosantana.agendador_tarefas.infrastructure.client;


import com.leandrosantana.agendador_tarefas.business.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {


    @GetMapping("/usuario")
    UsuarioDTO buscarUsuarioPorEmail(@RequestParam("email") String email,
                                     @RequestHeader("authorization") String token);


}
