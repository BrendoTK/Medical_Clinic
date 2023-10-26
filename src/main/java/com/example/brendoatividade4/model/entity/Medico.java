package com.example.brendoatividade4.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("Medico")
public class Medico extends Pessoa {

    private String crm;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;

    //getters e setters

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<Consulta> getConsultas(){
        return consultas;
    }

    public void setConsultasmedico(List<Consulta> consultas) {
        this.consultas = consultas;
    }


    @Override
    public String toString() {
        return "Dados{" +
                "crm='" + crm +
                ", consultas='" + consultas + '\'' +
                '}';
    }

}