package br.com.attornatus.cadastropessoas.pessoa.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.cadastropessoas.pessoa.application.service.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class PessoaController implements PessoaAPI {
	private final PessoaService pessoaService;

	@Override
	public PessoaResponse postPessoa(PessoaRequest pessoaRequest) {
		log.info("[inicia] PessoaController - postPessoa");
		PessoaResponse pessoaCriada = pessoaService.criaPessoa(pessoaRequest);
		log.info("[finaliza] PessoaController - postPessoa");
		return pessoaCriada;
	}

	@Override
	public List<PessoaListResponse> getTodasPessoas() {
		log.info("[inicia] PessoaController - getTodasPessoas");
		List<PessoaListResponse> pessoas = pessoaService.buscaTodosPessoas();
		log.info("[finaliza] PessoaController - getTodasPessoas");
		return pessoas;
	}

	@Override
	public PessoaDetalhadaResponse getPessoaAtravesId(UUID idPessoa) {
		log.info("[inicia] PessoaController - getPessoaAtravesId");
		log.info("[idPessoa] {}", idPessoa);
		PessoaDetalhadaResponse pessoaDetalhado = pessoaService.buscaPessoaAtravesId(idPessoa);
		log.info("[inicia] PessoaController - getPessoaAtravesId");
		return pessoaDetalhado;
	}

	@Override
	public void patchEditaPessoa(UUID idPessoa, @Valid PessoaRequest pessoaRequest) {
		log.info("[inicia] PessoaController - patchEditaPessoa");
		log.info("[idPessoa] {}", idPessoa);
		pessoaService.patchEditaPessoa(idPessoa, pessoaRequest);
		log.info("[finaliza] PessoaController - patchEditaPessoa");		
	}

	@Override
	public void deletaPessoaAtravesId(UUID idPessoa) {
		log.info("[inicia] PessoaController - deletaPessoaAtravesId");
		log.info("[finaliza] PessoaController - deletaPessoaAtravesId");
		
	}
}
