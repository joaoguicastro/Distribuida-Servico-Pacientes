package com.healthsys.pacientes.service;

import com.healthsys.pacientes.client.UsuarioClient;
import com.healthsys.pacientes.entity.PacienteEntity;
import com.healthsys.pacientes.event.PacienteCriadoEvent;
import com.healthsys.pacientes.messaging.PacienteProducer;
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

    @Autowired
    private PacienteProducer pacienteProducer;

    public PacienteEntity salvarPaciente (PacienteEntity paciente) {
        validaUsuario(paciente.getUsuarioId());

        PacienteEntity pacienteSalvo = pacienteRepository.save(paciente);

        PacienteCriadoEvent event = PacienteCriadoEvent.builder()
                .pacienteId(pacienteSalvo.getId())
                .usuarioId(pacienteSalvo.getUsuarioId())
                .nome(pacienteSalvo.getNome())
                .build();

        pacienteProducer.enviarEvento(event);

        return pacienteSalvo;
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
