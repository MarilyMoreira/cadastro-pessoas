package br.com.attornatus.cadastropessoas.pessoa.application.api;

import java.time.LocalDate;
import java.util.UUID;

import br.com.attornatus.cadastropessoas.pessoa.domain.Endereco;
import lombok.Getter;

@Getter
public class PessoaListResponse {
	private UUID idPessoa;
	private String nomeCompleto;
	private LocalDate dataNascimento;
	private Endereco endereco;
}
