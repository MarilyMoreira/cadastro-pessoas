package br.com.attornatus.cadastropessoas.endereco.application.service;

import java.util.List;
import java.util.UUID;

import br.com.attornatus.cadastropessoas.endereco.domain.Endereco;

public interface EnderecoRepository {
	Endereco salvaEndereco(Endereco endereco);
	List<Endereco> buscaEnderecosDaPessoaAtravesId(UUID idPessoa);
}
