package br.com.attornatus.cadastropessoas.endereco.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.attornatus.cadastropessoas.endereco.application.api.EnderecoRequest;
import br.com.attornatus.cadastropessoas.endereco.application.api.EnderecoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class EnderecoApplicationService implements EnderecoService {

	@Override
	public EnderecoResponse criaEndereco(UUID idPessoa, @Valid EnderecoRequest enderecoRequest) {
		log.info("[inicia] EnderecoApplicationService - criaEndereco");
		log.info("[finaliza] EnderecoApplicationService - criaEndereco");
		return null;
	}

}
