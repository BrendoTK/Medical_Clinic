package com.example.brendoatividade4.controller;

import com.example.brendoatividade4.model.entity.Consulta;
import com.example.brendoatividade4.model.entity.Paciente;
import com.example.brendoatividade4.model.entity.Paciente;
import com.example.brendoatividade4.model.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Transactional
@Controller
@RequestMapping("pacientes")
public class PacientesController {

    @Autowired
    PacienteRepository repository;



    /**
     * @param paciente necessário devido utilizar no form.html o th:object que faz referência ao objeto esperado no controller.
     * @return
     */
    @GetMapping("/form")
    public String form(Paciente paciente){
        return "/pacientes/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("pacientes", repository.pacientes());
        return new ModelAndView("pacientes/list", model);
    }

    @GetMapping("/listconsulpaciente/{id}")
    public ModelAndView listConsultasPaciente(@PathVariable("id") Long id, ModelMap model) {
        Paciente paciente = repository.findPacienteById(id);
        List<Consulta> consultas = paciente.getConsultas();
        model.addAttribute("consultas", consultas);
        return new ModelAndView("pacientes/listconsulpaciente", model);
    }


    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/pacientes/list");
    }

    @PostMapping("/save")
    public ModelAndView save(Paciente paciente){
        repository.save(paciente);
        return new ModelAndView("redirect:/pacientes/list");
    }

    @PostMapping("/update")
    public ModelAndView update(Paciente paciente) {
        repository.update(paciente);
        return new ModelAndView("redirect:/pacientes/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("paciente", repository.findPacienteById(id));
        return new ModelAndView("/pacientes/form", model);
    }

    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */


}