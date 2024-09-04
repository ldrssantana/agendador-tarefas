package com.leandrosantana.agendador_tarefas.controller;


import com.leandrosantana.agendador_tarefas.business.TarefasService;
import com.leandrosantana.agendador_tarefas.business.dto.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    public ResponseEntity<TarefasDTO> gravarTarefas(@RequestBody TarefasDTO dto,
                                                    @RequestHeader("authorization") String token) {
        return ResponseEntity.ok(tarefasService.gravarTarefa(token , dto));
    }
}

