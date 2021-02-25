package com.gestaotreinamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestaotreinamento.model.Sala;
import com.gestaotreinamento.repository.SalaRepository;

@Controller
public class SalaController {

	@Autowired
	private SalaRepository salaRepository;
	
	@GetMapping(value = "/cadastrarSala")
	public ModelAndView inicioSala() {
		ModelAndView modelAndView = new ModelAndView("paginas/cadastrosala");
		modelAndView.addObject("salas", salaRepository.findAll());
		
		return modelAndView;
	}
	
	@PostMapping(value = "/cadastrarSala")
	public ModelAndView cadastroSala(Sala sala) {
		salaRepository.save(sala);
		
		ModelAndView modelAndView = new ModelAndView("paginas/cadastrosala");
		Iterable<Sala> nomeSalas = salaRepository.findAll();
		modelAndView.addObject("msg", "Sala cadastrada com sucesso!");
		modelAndView.addObject("salas", nomeSalas);
		
		return modelAndView;
	}
}
