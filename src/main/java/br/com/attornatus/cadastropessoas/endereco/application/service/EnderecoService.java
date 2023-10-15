package br.com.attornatus.cadastropessoas.endereco.application.service;

import java.util.List;
import java.util.UUID;

import br.com.attornatus.cadastropessoas.endereco.application.api.EnderecoAlteracaoRequest;
import br.com.attornatus.cadastropessoas.endereco.application.api.EnderecoPessoaDetalhadoResponse;
import br.com.attornatus.cadastropessoas.endereco.application.api.EnderecoPessoaListResponse;
import br.com.attornatus.cadastropessoas.endereco.application.api.EnderecoRequest;
import br.com.attornatus.cadastropessoas.endereco.application.api.EnderecoResponse;
import jakarta.validation.Valid;

public interface EnderecoService {
	EnderecoResponse criaEndereco(UUID idPessoa, @Valid EnderecoRequest enderecoRequest);
	List<EnderecoPessoaListResponse> buscaEnderecosDaPessoaComId(UUID idPessoa);
	EnderecoPessoaDetalhadoResponse buscaEnderecoDaPessoaComId(UUID idPessoa, UUID idEndereco);
	void deletaEnderecoDaPessoaAtravesId(UUID idPessoa, UUID idEndereco);
	void alteraEnderecoDaPessoaComId(UUID idPessoa, UUID idEndereco, EnderecoAlteracaoRequest enderecoAlteracaoRequest);
}
