package br.com.attornatus.cadastropessoas.pessoa.application.api;

import java.time.LocalDate;

import br.com.attornatus.cadastropessoas.pessoa.domain.Endereco;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class PessoaRequest {
	@NotBlank
	private String nomeCompleto;
	@NotNull
	private LocalDate dataNascimento;
	@Embedded
	private Endereco endereco;
}
