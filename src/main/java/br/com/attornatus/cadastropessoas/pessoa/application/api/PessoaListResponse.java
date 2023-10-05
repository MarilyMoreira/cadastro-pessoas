package br.com.attornatus.cadastropessoas.pessoa.application.api;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import br.com.attornatus.cadastropessoas.pessoa.domain.Endereco;
import br.com.attornatus.cadastropessoas.pessoa.domain.Pessoa;
import lombok.Value;

@Value
public class PessoaListResponse {
	private UUID idPessoa;
	private String nomeCompleto;
	private LocalDate dataNascimento;
	private Endereco endereco;
	
	public static List<PessoaListResponse> converte(List<Pessoa> pessoas) {
		return null;
	}
}
