package com.healthsys.pacientes.service;

import com.healthsys.pacientes.entity.PacienteEntity;
import com.healthsys.pacientes.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteEntity salvarPaciente (PacienteEntity paciente) {
        return pacienteRepository.save(paciente);
    }
}
