package com.jjrockin.springboot.jpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String cpf;
    private String bairro;
    private LocalDate dataDeNascimento;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
