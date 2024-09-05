package com.leandrosantana.agendador_tarefas.infrastructure.repository;

import com.leandrosantana.agendador_tarefas.infrastructure.entity.TarefasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface  TarefasRepository  extends MongoRepository<TarefasEntity, String> {

   //Buscar usando Between
    List<TarefasEntity> findByDataEventoBetween(LocalDateTime dataInicial, LocalDateTime dataFinal);

    List<TarefasEntity> findByEmailUsuario(String email);
}


