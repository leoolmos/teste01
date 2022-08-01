package br.com.pedroaz.board.boardgamesbusca.controller;

import java.beans.Transient;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.pedroaz.board.boardgamesbusca.dto.RequisicaoNovoJogo;
import br.com.pedroaz.board.boardgamesbusca.model.DadosJogo;
import br.com.pedroaz.board.boardgamesbusca.repository.DadosJogosRepository;

@Controller
@Repository
public class JogosAddController {
	
//-----------------@Autowired--------------------------------------------------
	//spring cria uma instância dessa classe
	// e vai utilizar essa classe para salvar os dados no banco de dados
	
	@Autowired
	private DadosJogosRepository dadosJogosRepository;
	
	@GetMapping("/dados/formulario")
	public String formulario(RequisicaoNovoJogo requisicao) {
		return "dados/formulario";
	}
	
	
	@PostMapping("dados/novo")
	public String novo(@Valid RequisicaoNovoJogo requisicao,BindingResult result) {
		if(result.hasErrors()) {
			return "dados/formulario";
		}
		DadosJogo dadosJogo = requisicao.toDadosJogos();
		dadosJogosRepository.save(dadosJogo);	
		return "redirect:/index";
	}

}
