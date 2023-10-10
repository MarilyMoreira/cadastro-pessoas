package br.com.attornatus.cadastropessoas.endereco.application.service;

import java.util.UUID;

import br.com.attornatus.cadastropessoas.endereco.application.api.EnderecoRequest;
import br.com.attornatus.cadastropessoas.endereco.application.api.EnderecoResponse;
import jakarta.validation.Valid;

public interface EnderecoService {
	EnderecoResponse criaEndereco(UUID idPessoa, @Valid EnderecoRequest enderecoRequest);
}
