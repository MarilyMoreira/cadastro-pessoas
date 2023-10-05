package br.com.attornatus.cadastropessoas.pessoa.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.attornatus.cadastropessoas.pessoa.domain.Pessoa;

public interface PessoaRepository {
	Pessoa salva(Pessoa pessoa);
	List<Pessoa> buscaTodosPessoas();
	Pessoa buscaPessoaAtravesId(UUID idPessoa);
}
