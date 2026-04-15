package com.healthsys.pacientes.controller;

import com.healthsys.pacientes.dtos.paciente.PacienteRequestDTO;
import com.healthsys.pacientes.dtos.paciente.PacienteResponseDTO;
import com.healthsys.pacientes.entity.PacienteEntity;
import com.healthsys.pacientes.mapper.PacienteMapper;
import com.healthsys.pacientes.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private PacienteMapper pacienteMapper;

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> cadastrarPaciente (@RequestBody PacienteRequestDTO paciente) {
        PacienteEntity entity = pacienteMapper.toEntity(paciente);

        PacienteEntity pacienteSalvc = pacienteService.salvarPaciente(entity);

        PacienteResponseDTO dto = pacienteMapper.toDTO(pacienteSalvc);

        return ResponseEntity.ok(dto);
    }
}