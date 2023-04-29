package com.jjrockin.springboot.jpa.service.impl;

import com.jjrockin.springboot.jpa.entities.Aluno;
import com.jjrockin.springboot.jpa.entities.Matricula;
import com.jjrockin.springboot.jpa.entities.form.MatriculaForm;
import com.jjrockin.springboot.jpa.repositories.AlunoRepository;
import com.jjrockin.springboot.jpa.repositories.MatriculaRepository;
import com.jjrockin.springboot.jpa.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements IMatriculaService {
    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        matricula.setAluno(aluno);

        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula get(Long id) {
        return matriculaRepository.findById(id).get();
    }

    @Override
    public List<Matricula> getAll(String bairro) {

        if(bairro == null){
            return matriculaRepository.findAll();
        }else{
            return matriculaRepository.findAlunosMatriculadosBairro(bairro);
        }

    }

    @Override
    public void delete(Long id) {}


}
