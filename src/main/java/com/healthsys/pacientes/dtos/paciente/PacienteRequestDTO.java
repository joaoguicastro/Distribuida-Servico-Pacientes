package com.healthsys.pacientes.dtos.paciente;

import com.healthsys.pacientes.enums.SexoPaciente;

import java.time.LocalDate;

public record PacienteRequestDTO (
        String nome,
        LocalDate dataNascimento,
        SexoPaciente sexo,
        String telefone,
        Long usuarioId
) {
}
