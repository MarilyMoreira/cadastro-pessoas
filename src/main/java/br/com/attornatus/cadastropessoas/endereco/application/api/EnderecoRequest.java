package br.com.attornatus.cadastropessoas.endereco.application.api;

import lombok.Value;

@Value
public class EnderecoRequest {
	private String logradouro;
	private String CEP;
	private String numero;
}
