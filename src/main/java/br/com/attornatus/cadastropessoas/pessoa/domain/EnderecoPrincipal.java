package br.com.attornatus.cadastropessoas.pessoa.domain;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnderecoPrincipal {
	@NotNull(message = "Logradouro não pode ser nulo!")
	private String logradouro;
	@NotNull(message = "CEP não pode ser nulo!")
	private String cep;
	@NotNull(message = "Número não pode ser nulo!")
	private String numero;
}
