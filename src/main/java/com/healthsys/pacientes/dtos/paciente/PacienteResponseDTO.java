package com.healthsys.pacientes.dtos.paciente;

import com.healthsys.pacientes.enums.SexoPaciente;

import java.time.LocalDate;

public record PacienteResponseDTO(
        Long id,
        String nome,
        LocalDate dataNascimento,
        SexoPaciente sexo,
        String telefone
) {
}
