package com.leandrosantana.agendador_tarefas.infrastructure.repository;

import com.leandrosantana.agendador_tarefas.infrastructure.entity.TarefasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  TarefasRepository  extends MongoRepository<TarefasEntity, String> {


}
