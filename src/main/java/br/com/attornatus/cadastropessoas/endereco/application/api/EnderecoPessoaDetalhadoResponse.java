package br.com.attornatus.cadastropessoas.endereco.application.api;

import java.util.UUID;

import br.com.attornatus.cadastropessoas.endereco.domain.Endereco;
import lombok.Value;

@Value
public class EnderecoPessoaDetalhadoResponse {
	private UUID idEndereco;
	private UUID idPessoa;
	private String logradouro;
	private String cep;
	private String numero;

	public EnderecoPessoaDetalhadoResponse(Endereco endereco) {
		this.idEndereco = endereco.getIdEndereco();
		this.idPessoa = endereco.getIdPessoa();
		this.logradouro = endereco.getLogradouro();
		this.cep = endereco.getCep();
		this.numero = endereco.getNumero();
	}
}
