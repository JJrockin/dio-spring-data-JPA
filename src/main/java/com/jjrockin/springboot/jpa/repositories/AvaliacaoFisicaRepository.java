package com.jjrockin.springboot.jpa.repositories;

import com.jjrockin.springboot.jpa.entities.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long> {
}
