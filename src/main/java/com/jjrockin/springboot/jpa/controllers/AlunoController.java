package com.jjrockin.springboot.jpa.controllers;

import com.jjrockin.springboot.jpa.entities.Aluno;
import com.jjrockin.springboot.jpa.entities.AvaliacaoFisica;
import com.jjrockin.springboot.jpa.entities.form.AlunoForm;
import com.jjrockin.springboot.jpa.service.impl.AlunoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoServiceImpl service;
    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                                  String dataDeNacimento){
        return service.getAll(dataDeNacimento);
    }
    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
        return service.getAllAvaliacaoFisicaId(id);
    }
    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form){
        return service.create(form);
    }

}
