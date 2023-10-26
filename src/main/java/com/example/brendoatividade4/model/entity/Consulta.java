package com.example.brendoatividade4.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Consulta{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String data;

    private double valor;

    private String observacao;

    @ManyToOne()
    @JoinColumn(name = "id_paciente")
    @OnDelete(action = OnDeleteAction.CASCADE) // Definindo ação de cascata
    private Paciente paciente;

    @ManyToOne()
    @JoinColumn(name = "id_medico")
    @OnDelete(action = OnDeleteAction.CASCADE) // Definindo ação de cascata
    private Medico medico;

    //getters e setters


    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", data='" + data +
                ", valor='" + valor +
                ", paciente='" + paciente +
                ", medico='" + medico +
                ", observacao='" + observacao + '\'' +
                '}';
    }

}