package br.com.attornatus.cadastropessoas.pessoa.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Endereco {
	private String logradouro;
	private String CEP;
	private String numero;
}
