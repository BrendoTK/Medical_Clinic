package com.example.brendoatividade4.controller;

import com.example.brendoatividade4.model.entity.Consulta;
import com.example.brendoatividade4.model.entity.Medico;
import com.example.brendoatividade4.model.entity.Paciente;
import com.example.brendoatividade4.model.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Transactional
@Controller
@RequestMapping("consultas")
public class ConsultasController {

    @Autowired
    ConsultaRepository repository;

    @Autowired
    private PacienteRepository2 pacienteRepository;

    @Autowired
    private MedicoRepository2 medicoRepository;



    /**
     * @param consulta necessário devido utilizar no form.html o th:object que faz referência ao objeto esperado no controller.
     * @return
     */
    // Mapeamento para exibir o formulário de consulta
    @GetMapping("/form")
    public String form(Consulta consulta, Model model) {
        // Busque todos os pacientes e médicos
        List<Paciente> pacientes = pacienteRepository.findAll();
        List<Medico> medicos = medicoRepository.findAll();

        // Adicione os pacientes e médicos ao modelo
        model.addAttribute("consulta", consulta);
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("medicos", medicos);

        return "consultas/form"; // Renderize a página do formulário de consulta
    }



    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("consultas", repository.consultas());
        return new ModelAndView("/consultas/list", model);
    }







    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/consultas/list");
    }

    @PostMapping("/save")
    public ModelAndView save(Consulta consulta){
        repository.save(consulta);
        return new ModelAndView("redirect:/consultas/list");
    }

    @PostMapping("/update")
    public ModelAndView update(Consulta consulta) {
        repository.update(consulta);
        return new ModelAndView("redirect:/consultas/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("consulta", repository.findConsultaById(id));
        return new ModelAndView("/consultas/form", model);
    }


    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */


}