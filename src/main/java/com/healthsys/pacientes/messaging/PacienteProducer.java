package com.healthsys.pacientes.messaging;

import com.healthsys.pacientes.event.PacienteCriadoEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class PacienteProducer {
    private final RabbitTemplate rabbitTemplate;


    public PacienteProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarEvento (PacienteCriadoEvent event) {
        rabbitTemplate.convertAndSend(
                "paciente.exchange",
                "paciente.criado",
                event
        );
    }
}
