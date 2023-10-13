package br.com.attornatus.cadastropessoas.endereco.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.attornatus.cadastropessoas.endereco.domain.Endereco;
import lombok.Getter;

@Getter
public class EnderecoPessoaListResponse {
	private UUID idEndereco;
	private String logradouro;
	private String cep;
	private String numero;
	
	public static List<EnderecoPessoaListResponse> converte(List<Endereco> enderecosDaPessoa) {
		return enderecosDaPessoa.stream()
				.map(EnderecoPessoaListResponse::new)
				.collect(Collectors.toList());
	}

	public EnderecoPessoaListResponse(Endereco endereco) {
		this.idEndereco = endereco.getIdEndereco();
		this.logradouro = endereco.getLogradouro();
		this.cep = endereco.getCep();
		this.numero = endereco.getNumero();
	}
}
