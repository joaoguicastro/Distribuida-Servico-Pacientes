package com.healthsys.pacientes.messaging;

import com.healthsys.pacientes.event.PacienteCriadoEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class PacienteProducer {
    private final RabbitTemplate rabbitTemplate;

    public PacienteProducer(RabbitTemplate rabbitTemplate,
                            Jackson2JsonMessageConverter messageConverter) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setMessageConverter(messageConverter);
    }

    public void enviarEvento(PacienteCriadoEvent event) {
        rabbitTemplate.convertAndSend(
                "paciente.exchange",
                "paciente.criado",
                event
        );
    }
}
