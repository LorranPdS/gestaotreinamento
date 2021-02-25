package com.gestaotreinamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestaotreinamento.model.Pessoa;
import com.gestaotreinamento.repository.PessoaRepository;
import com.gestaotreinamento.repository.SalaRepository;

@Controller
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private SalaRepository salaRepository;

	@GetMapping(value = "/cadastropessoa")
	public ModelAndView inicioPessoa() {
		ModelAndView modelAndView;
		int qtdSalas = salaRepository.findTotalSalas();

		// Para fazer com que haja pelo menos duas salas já cadastradas
		if (qtdSalas < 2) {
			modelAndView = new ModelAndView("index");
			modelAndView.addObject("msg",
					"Cadastre pelo menos" + " duas salas no sistema para que você possa" + " cadastrar uma pessoa");
			return modelAndView;
		}
		modelAndView = new ModelAndView("paginas/cadastropessoa");

		return modelAndView;
	}

	@PostMapping(value = "/cadastrarpessoa")
	public ModelAndView cadastroPessoa(Pessoa pessoa) {

		pessoaRepository.save(pessoa);

		ModelAndView modelAndView = new ModelAndView("paginas/cadastropessoa");
		modelAndView.addObject("msg", "Pessoa cadastrada com sucesso!");
		return modelAndView;
	}

	@GetMapping(value = "/listaDeCadastrados")
	public ModelAndView pessoasCadastradas() {
		ModelAndView modelAndView = new ModelAndView("paginas/listacadastrados");
		Iterable<Pessoa> totalPessoas = pessoaRepository.findAll();
		modelAndView.addObject("pessoas", totalPessoas);
		return modelAndView;
	}

	// NÃO ESQUECER DE CRIAR UM MÉTODO DO LADO DE FORA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	@GetMapping(value = "/distribuir")
	public ModelAndView distribuirPessoas() {

		ModelAndView modelAndView;
		List<Pessoa> pessoasCadastradas = (List<Pessoa>) pessoaRepository.findAll();

		if (pessoasCadastradas.size() < 4) {
			modelAndView = new ModelAndView("paginas/cadastropessoa");
			modelAndView.addObject("msg", "Você precisa cadastrar ao menos 4 pessoas no sistema");
		} else {
			
			/* Criar um método do lado de fora para fazer esse negócio gigante aqui*/

			List<Long> salasCadastradas = salaRepository.findAllId();
			
			// Por aqui eu consigo tirar a média
			int media = pessoasCadastradas.size() / salasCadastradas.size();
			
			for(int i = 0; i < pessoasCadastradas.size(); i++) {
				
				// Para quem estiver abaixo da média
				if(pessoasCadastradas.get(i).getId() <= media) {
					
					// Abaixo da média e ímpar
					if(pessoasCadastradas.get(i).getId() % 2 == 1) {
						pessoasCadastradas.get(i).setSalaEtapa1(1L);
						pessoasCadastradas.get(i).setSalaEtapa2(1L);
						pessoasCadastradas.get(i).setCafeEtapa1("Espaço para Café 1");
						pessoasCadastradas.get(i).setCafeEtapa2("Espaço para Café 1");
					} 
					
					// Abaixo da média e par
					else {
						pessoasCadastradas.get(i).setSalaEtapa1(2L);
						pessoasCadastradas.get(i).setSalaEtapa2(2L);
						pessoasCadastradas.get(i).setCafeEtapa1("Espaço para Café 2");
						pessoasCadastradas.get(i).setCafeEtapa2("Espaço para Café 2");
					}
				}
				
				// Para quem estiver acima da média
				else {
					
					// Acima da média e ímpar
					if(pessoasCadastradas.get(i).getId() % 2 == 1) {
						pessoasCadastradas.get(i).setSalaEtapa1(2L);
						pessoasCadastradas.get(i).setSalaEtapa2(2L);
						pessoasCadastradas.get(i).setCafeEtapa1("Espaço para Café 1");
						pessoasCadastradas.get(i).setCafeEtapa2("Espaço para Café 1");
					} 
					
					// Acima da média e par
					else {
						pessoasCadastradas.get(i).setSalaEtapa1(1L);
						pessoasCadastradas.get(i).setSalaEtapa2(1L);
						pessoasCadastradas.get(i).setCafeEtapa1("Espaço para Café 2");
						pessoasCadastradas.get(i).setCafeEtapa2("Espaço para Café 2");
					}
				}
			}
			
			/* Daqui para cima é o método*/
			
			for(int i = 0; i < pessoasCadastradas.size(); i++) {
				pessoaRepository.save(pessoasCadastradas.get(i));
			}

			modelAndView = new ModelAndView("paginas/listacadastrados");
			modelAndView.addObject("pessoas", pessoaRepository.findAll());
			modelAndView.addObject("msg", "Pessoas foram distribuídas pelos locais com sucesso!");
		}
		
		return modelAndView;
	}

}
