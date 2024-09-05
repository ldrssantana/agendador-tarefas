package com.leandrosantana.agendador_tarefas.infrastructure.entity;


import com.leandrosantana.agendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
//Anotações para Mongo DB
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("tarefa")
public class TarefasEntity {

    @Id
    private String id;

    private String nomeTarefa;
    private String descricao;
    private LocalDateTime dataCriacao; //LocalDate apenas data
    private LocalDateTime dataEvento;
    private String emailUsuario;
    private LocalDateTime dataAlteracao;
    private StatusNotificacaoEnum statusNotificacaoEnum;

}
