package com.healthsys.pacientes.entity;

import com.healthsys.pacientes.enums.SexoPaciente;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "TB_PAC")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAC")
    private Long id;

    @Column(name = "NM_PAC")
    private String nome;

    @Column(name = "DT_NSC_PAC")
    private LocalDate dataNascimento;

    @Column(name = "SX_PAC")
    @Enumerated(EnumType.STRING)
    private SexoPaciente sexo;

    @Column(name = "TEL_PAC")
    private String telefone;

    @Column(name = "ID_USU", nullable = false)
    private Long usuarioId;
}
