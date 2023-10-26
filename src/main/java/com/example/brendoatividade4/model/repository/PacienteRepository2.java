package com.example.brendoatividade4.model.repository;

import com.example.brendoatividade4.model.entity.Paciente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface PacienteRepository2 extends JpaRepository<Paciente, Long> {
    List<Paciente> findAll(); // Método para buscar todos os pacientes
}