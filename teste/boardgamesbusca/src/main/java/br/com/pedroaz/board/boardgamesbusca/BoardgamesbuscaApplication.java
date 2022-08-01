//Spring Boot | Controller | Banco de Dados | Thymeleaf
//https://www.youtube.com/watch?v=iInRjoE0abM
package br.com.pedroaz.board.boardgamesbusca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication
public class BoardgamesbuscaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardgamesbuscaApplication.class, args);
	}

}
