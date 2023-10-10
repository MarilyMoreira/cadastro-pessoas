package br.com.attornatus.cadastropessoas.endereco.application.service;

import br.com.attornatus.cadastropessoas.endereco.domain.Endereco;

public interface EnderecoRepository {
	Endereco salvaEndereco(Endereco endereco);
}
