package com.example.brendoatividade4.controller;

import com.example.brendoatividade4.model.entity.Consulta;
import com.example.brendoatividade4.model.entity.Medico;
import com.example.brendoatividade4.model.repository.MedicoRepository;
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
@RequestMapping("medicos")
public class MedicosController {

    @Autowired
    MedicoRepository repository;



    /**
     * @param medico necessário devido utilizar no form.html o th:object que faz referência ao objeto esperado no controller.
     * @return
     */
    @GetMapping("/form")
    public String form(Medico medico){
        return "/medicos/form";
    }



    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("medicos", repository.medicos());
        return new ModelAndView("medicos/list", model);
    }





    @GetMapping("/listconsulmedico/{id}")
    public ModelAndView listConsultasMedico(@PathVariable("id") Long id, ModelMap model) {
        Medico medico = repository.findMedicoById(id);
        List<Consulta> consultas = medico.getConsultas();
        model.addAttribute("consultas", consultas);
        return new ModelAndView("medicos/listconsulmedico", model);
    }


    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/medicos/list");
    }

    @PostMapping("/save")
    public ModelAndView save(Medico medico){
        repository.save(medico);
        return new ModelAndView("redirect:/medicos/list");
    }

    @PostMapping("/update")
    public ModelAndView update(Medico medico) {
        repository.update(medico);
        return new ModelAndView("redirect:/medicos/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("medico", repository.findMedicoById(id));
        return new ModelAndView("/medicos/form", model);
    }
    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */


}