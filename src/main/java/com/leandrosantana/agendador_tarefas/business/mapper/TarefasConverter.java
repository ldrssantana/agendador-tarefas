package com.leandrosantana.agendador_tarefas.business.mapper;

import com.leandrosantana.agendador_tarefas.business.dto.TarefasDTO;
import com.leandrosantana.agendador_tarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    //Forcar, sendo o source para o TarefasEntity e o targer para DTO.
    @Mapping(source = "id" , target = "id")
    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}
