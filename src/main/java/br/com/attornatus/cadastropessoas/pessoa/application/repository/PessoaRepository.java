package br.com.attornatus.cadastropessoas.pessoa.application.repository;

import br.com.attornatus.cadastropessoas.pessoa.domain.Pessoa;

public interface PessoaRepository {
	Pessoa salva(Pessoa pessoa);
}
