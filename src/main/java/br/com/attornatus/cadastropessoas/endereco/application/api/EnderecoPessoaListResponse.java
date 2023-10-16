package br.com.attornatus.cadastropessoas.endereco.application.api;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.attornatus.cadastropessoas.endereco.domain.Endereco;
import br.com.attornatus.cadastropessoas.pessoa.application.api.PessoaListResponse;
import br.com.attornatus.cadastropessoas.pessoa.domain.EnderecoPrincipal;
import br.com.attornatus.cadastropessoas.pessoa.domain.Pessoa;
import lombok.Getter;

@Getter
public class EnderecoPessoaListResponse {
	private UUID idEndereco;
	private String logradouro;
	private String cep;
	private String numero;
	private EnderecoPrincipal enderecoPrincipal;

	public EnderecoPessoaListResponse(Endereco endereco, Pessoa pessoa) {
		this.idEndereco = endereco.getIdEndereco();
		this.logradouro = endereco.getLogradouro();
		this.cep = endereco.getCep();
		this.numero = endereco.getNumero();
		this.enderecoPrincipal = pessoa.getEnderecoPrincipal();	
	}

	public static List<EnderecoPessoaListResponse> converte(List<Endereco> enderecosDaPessoa, List<PessoaListResponse> listarEnderecosPessoa) {
        Map<UUID, Pessoa> pessoaMap = listarEnderecosPessoa.stream()
                .collect(Collectors.toMap(PessoaListResponse::getIdPessoa, pessoaListResponse -> new Pessoa(pessoaListResponse)));

            return enderecosDaPessoa.stream()
            	.map(endereco -> new EnderecoPessoaListResponse(endereco, pessoaMap.get(endereco.getIdPessoa())))
                .collect(Collectors.toList());
    }

}
	