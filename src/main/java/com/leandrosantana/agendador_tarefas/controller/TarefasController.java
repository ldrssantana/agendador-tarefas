package com.leandrosantana.agendador_tarefas.controller;


import com.leandrosantana.agendador_tarefas.business.TarefasService;
import com.leandrosantana.agendador_tarefas.business.dto.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/eventos")
    public ResponseEntity<List<TarefasDTO>> buscaListadeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal) {
            return ResponseEntity.ok(tarefasService.buscaTarefasAgedandasPorPeriodo(dataInicial, dataFinal));

    }

    @GetMapping
    public ResponseEntity<List<TarefasDTO>> buscaTarefasPorEmail(@RequestHeader("Authorization") String token){
        //List<TarefasDTO> tarefas = tarefasService.buscaTarefasPorEmail(token); //Apenas demostrando forma extensa
        //return ResponseEntity.ok(tarefas);
        return ResponseEntity.ok(tarefasService.buscaTarefasPorEmail(token));
    }


}
















