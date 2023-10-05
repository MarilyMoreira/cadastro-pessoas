package br.com.attornatus.cadastropessoas.pessoa.application.repository;

import java.util.List;

import br.com.attornatus.cadastropessoas.pessoa.domain.Pessoa;

public interface PessoaRepository {
	Pessoa salva(Pessoa pessoa);
	List<Pessoa> buscaTodosPessoas();
}
