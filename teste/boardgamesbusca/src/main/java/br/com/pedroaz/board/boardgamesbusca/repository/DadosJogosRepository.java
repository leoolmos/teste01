package br.com.pedroaz.board.boardgamesbusca.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pedroaz.board.boardgamesbusca.model.DadosJogo;


@Transactional
@Repository
public interface DadosJogosRepository extends CrudRepository<DadosJogo,Long> {

	
	List<DadosJogo> findAll(Pageable sort);
	
	List<DadosJogo> findByNomeDoJogoContains(String nome);
	
	
	}
	



	
//--------------------------tecnologia Spring DATA JPA---------------------------------- 
	
// ---------------------public List<DadosJogo> findAll ();----------------------------
	



