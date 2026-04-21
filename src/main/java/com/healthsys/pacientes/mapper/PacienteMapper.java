package com.healthsys.pacientes.mapper;

import com.healthsys.pacientes.dtos.paciente.PacienteRequestDTO;
import com.healthsys.pacientes.dtos.paciente.PacienteResponseDTO;
import com.healthsys.pacientes.entity.PacienteEntity;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {

    public PacienteResponseDTO toDTO (PacienteEntity entity){
        return new PacienteResponseDTO(
                entity.getId(),
                entity.getNome(),
                entity.getDataNascimento(),
                entity.getSexo(),
                entity.getTelefone(),
                entity.getUsuarioId()
        );
    }


    public PacienteEntity toEntity (PacienteRequestDTO dto) {
        return PacienteEntity.builder()
                .nome(dto.nome())
                .dataNascimento(dto.dataNascimento())
                .sexo(dto.sexo())
                .telefone(dto.telefone())
                .usuarioId(dto.usuarioId())
                .build();
    }
}
