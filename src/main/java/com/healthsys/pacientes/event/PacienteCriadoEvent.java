package com.healthsys.pacientes.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PacienteCriadoEvent {

    private Long pacienteId;
    private Long usuarioId;
    private String nome;
}
