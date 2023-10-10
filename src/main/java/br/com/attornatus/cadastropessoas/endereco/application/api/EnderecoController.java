package br.com.attornatus.cadastropessoas.endereco.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.cadastropessoas.endereco.application.service.EnderecoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class EnderecoController implements EnderecoAPI {
	private final EnderecoService enderecoService;

	@Override
	public EnderecoResponse postEndereco(UUID idPessoa, @Valid EnderecoRequest enderecoRequest) {
		log.info("[inicia] EnderecoController - postEndereco");
		log.info("[idPessoa] {}", idPessoa);
		EnderecoResponse enderecoCriado = enderecoService.criaEndereco(idPessoa, enderecoRequest);
		log.info("[finaliza] EnderecoController - postEndereco");
		return enderecoCriado;
	}

}
