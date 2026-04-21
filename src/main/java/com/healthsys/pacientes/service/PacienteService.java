package com.healthsys.pacientes.service;

import com.healthsys.pacientes.client.UsuarioClient;
import com.healthsys.pacientes.entity.PacienteEntity;
import com.healthsys.pacientes.repository.PacienteRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    public PacienteEntity salvarPaciente (PacienteEntity paciente) {
        validaUsuario(paciente.getUsuarioId());

        return pacienteRepository.save(paciente);
    }

    public void validaUsuario(Long usuarioId) {
        System.out.println("ID enviado pro usuario-service: " + usuarioId);
        if (usuarioId == null) {
            throw new RuntimeException("ID está NULL");
        }

        try {
            usuarioClient.buscarUsuario(usuarioId);
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("Usuário não encontrado");
        }
    }
}
