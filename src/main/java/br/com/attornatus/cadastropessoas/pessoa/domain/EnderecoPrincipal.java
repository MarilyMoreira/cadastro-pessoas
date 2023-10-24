package br.com.attornatus.cadastropessoas.pessoa.domain;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Embeddable
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class EnderecoPrincipal {
	private String logradouro;
	private String CEP;
	private String numero;
}
