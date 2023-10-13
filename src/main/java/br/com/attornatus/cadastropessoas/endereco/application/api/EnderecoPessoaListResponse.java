package br.com.attornatus.cadastropessoas.endereco.application.api;

import java.util.List;
import java.util.UUID;

import br.com.attornatus.cadastropessoas.endereco.domain.Endereco;
import lombok.Getter;

@Getter
public class EnderecoPessoaListResponse {
	private UUID idEndereco;
	private String logradouro;
	private String CEP;
	private String numero;
	
	public static List<EnderecoPessoaListResponse> converte(List<Endereco> enderecosDaPessoa) {
		return null;
	}
}
