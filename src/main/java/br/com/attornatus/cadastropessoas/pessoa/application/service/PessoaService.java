package br.com.attornatus.cadastropessoas.pessoa.application.service;

import java.util.List;

import br.com.attornatus.cadastropessoas.pessoa.application.api.PessoaListResponse;
import br.com.attornatus.cadastropessoas.pessoa.application.api.PessoaRequest;
import br.com.attornatus.cadastropessoas.pessoa.application.api.PessoaResponse;

public interface PessoaService {
	PessoaResponse criaPessoa(PessoaRequest pessoaRequest);
	List<PessoaListResponse> buscaTodosPessoas();
}
