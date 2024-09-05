package com.leandrosantana.agendador_tarefas.business;


import com.leandrosantana.agendador_tarefas.business.dto.TarefasDTO;
import com.leandrosantana.agendador_tarefas.business.mapper.TarefasConverter;
import com.leandrosantana.agendador_tarefas.infrastructure.entity.TarefasEntity;
import com.leandrosantana.agendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.leandrosantana.agendador_tarefas.infrastructure.repository.TarefasRepository;
import com.leandrosantana.agendador_tarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    //Converter de DTO para Entity
    public TarefasDTO gravarTarefa(String token ,TarefasDTO dto) {
            String email = jwtUtil.extrairEmailToken(token.substring(7));
            dto.setDataCriacao(LocalDateTime.now());
            dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
            dto.setEmailUsuario(email);
            TarefasEntity entity = tarefasConverter.paraTarefaEntity(dto);
            return tarefasConverter.paraTarefaDTO
                    (tarefasRepository.save(entity));
    }

    public List<TarefasDTO> buscaTarefasAgedandasPorPeriodo( LocalDateTime dataInicial, LocalDateTime dataFinal ) {
              return tarefasConverter.paraListaTarefasDTO(
                      tarefasRepository.findByDataEventoBetween(dataInicial, dataFinal));

    }

    public List<TarefasDTO> buscaTarefasPorEmail(String token){
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        List<TarefasEntity> listaTarefas = tarefasRepository.findByEmailUsuario(email);
        return tarefasConverter.paraListaTarefasDTO(listaTarefas);
    }




}
