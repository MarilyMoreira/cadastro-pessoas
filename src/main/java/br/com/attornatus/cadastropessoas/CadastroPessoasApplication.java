package br.com.attornatus.cadastropessoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class CadastroPessoasApplication {
	
	@GetMapping
	public String getHomeTeste() {
		return "Cadastro Pessoas - API Home";		
	}

	public static void main(String[] args) {
		SpringApplication.run(CadastroPessoasApplication.class, args);
	}

}
