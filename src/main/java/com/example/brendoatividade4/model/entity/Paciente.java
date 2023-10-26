package com.example.brendoatividade4.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("Paciente")
public class Paciente extends Pessoa {
    private String telefone;



    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;

    //getters e setters
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Consulta> getConsultas(){
        return consultas;
    }

    @Override
    public String toString() {
        return "Dados{" +
                "telefone='" + telefone +
                ", consultas='" + consultas + '\'' +
                '}';
    }

}