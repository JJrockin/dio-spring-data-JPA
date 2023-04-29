package com.jjrockin.springboot.jpa.controllers;

import com.jjrockin.springboot.jpa.entities.AvaliacaoFisica;
import com.jjrockin.springboot.jpa.entities.form.AvaliacaoFisicaForm;
import com.jjrockin.springboot.jpa.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {
    @Autowired
    private AvaliacaoFisicaServiceImpl service;

    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
        return service.create(form);
    }

    @GetMapping
    public List<AvaliacaoFisica> getAll(){
        return service.getAll();
    }
}
