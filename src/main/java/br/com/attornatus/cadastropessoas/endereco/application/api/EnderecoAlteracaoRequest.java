package br.com.attornatus.cadastropessoas.endereco.application.api;

import lombok.Value;

@Value
public class EnderecoAlteracaoRequest {
	private String logradouro;
	private String cep;
	private String numero;
}
