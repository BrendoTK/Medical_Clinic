package com.example.brendoatividade4.model.repository;

import com.example.brendoatividade4.model.entity.Medico;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface MedicoRepository2 extends JpaRepository<Medico, Long> {
    List<Medico> findAll(); // Método para buscar todos os médicos
}