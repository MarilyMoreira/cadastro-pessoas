package br.com.attornatus.cadastropessoas.pessoa.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.attornatus.cadastropessoas.pessoa.domain.Pessoa;

public interface PessoaRepository {
	Pessoa salva(Pessoa pessoa);
	List<Pessoa> buscaTodasPessoas();
	Pessoa buscaPessoaAtravesId(UUID idPessoa);
	void deleta(Pessoa pessoa);
}
