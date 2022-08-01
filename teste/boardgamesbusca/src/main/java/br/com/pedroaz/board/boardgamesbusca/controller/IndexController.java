package br.com.pedroaz.board.boardgamesbusca.controller;



import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import br.com.pedroaz.board.boardgamesbusca.model.DadosJogo;
import br.com.pedroaz.board.boardgamesbusca.repository.DadosJogosRepository;

@Repository
@Controller
public class IndexController {
	
	@Autowired
	private DadosJogosRepository pedidoRepository;
	
	
	
	@GetMapping("/index")
	public String index(Model model, Principal principal) {
		

		PageRequest paginacao = PageRequest.of(0,7);

		List<DadosJogo>dados = pedidoRepository.findAll(paginacao);
		model.addAttribute("dados",dados);

		return "/index";
	}
	

	@RequestMapping("/preco")
	public String preco(Model model, Principal principal) {
		
		Sort sort = Sort.by("preco").ascending();
		PageRequest paginacao = PageRequest.of(0,7,sort);
		
		List<DadosJogo>dados = pedidoRepository.findAll(paginacao);
		model.addAttribute("dados",dados);

		return "/index";
		
	}
	
	@RequestMapping("/notas")
	public String notas(Model model, Principal principal) {
		
		Sort sort = Sort.by("nota").descending();
		PageRequest paginacao = PageRequest.of(0,7,sort);
		
		List<DadosJogo>dados = pedidoRepository.findAll(paginacao);
		model.addAttribute("dados",dados);

		return "/index";
		
	}
	
	@RequestMapping("/lista")
	public ModelAndView pesquisar (@RequestParam("nomeJogo")String nomeJogo){
		
	
		ModelAndView modelAndView = new ModelAndView("/index");
		modelAndView.addObject("dados",pedidoRepository.findByNomeDoJogoContains(nomeJogo));
		return modelAndView;
	}
	
	
	
	
}
	

	








