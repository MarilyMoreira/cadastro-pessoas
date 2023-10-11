package br.com.attornatus.cadastropessoas.endereco.application.api;

import java.util.UUID;

import lombok.Value;

@Value
public class EnderecoPessoaListResponse {
	private UUID idEndereco;
	private UUID idPessoa;
	private String logradouro;
	private String CEP;
	private String numero;
}
