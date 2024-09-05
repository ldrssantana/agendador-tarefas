package com.leandrosantana.agendador_tarefas.business.mapper;

import com.leandrosantana.agendador_tarefas.business.dto.TarefasDTO;
import com.leandrosantana.agendador_tarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    //Forcar, sendo o source para o TarefasEntity e o target para DTO.
    @Mapping(source = "id" , target = "id")
    @Mapping(source = "dataEvento" , target = "dataEvento")
    @Mapping(source = "dataAlteracao" , target = "dataAlteracao")


    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);

    List<TarefasEntity> paraListaTarefasEntity(List<TarefasDTO> dtos);

    List<TarefasDTO> paraListaTarefasDTO(List<TarefasEntity> entities);
}
