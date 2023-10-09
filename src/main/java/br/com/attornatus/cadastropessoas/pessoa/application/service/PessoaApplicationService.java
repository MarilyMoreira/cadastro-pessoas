package br.com.attornatus.cadastropessoas.pessoa.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.attornatus.cadastropessoas.pessoa.application.api.PessoaDetalhadaResponse;
import br.com.attornatus.cadastropessoas.pessoa.application.api.PessoaListResponse;
import br.com.attornatus.cadastropessoas.pessoa.application.api.PessoaRequest;
import br.com.attornatus.cadastropessoas.pessoa.application.api.PessoaResponse;
import br.com.attornatus.cadastropessoas.pessoa.application.repository.PessoaRepository;
import br.com.attornatus.cadastropessoas.pessoa.domain.Pessoa;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PessoaApplicationService implements PessoaService {
	private final PessoaRepository pessoaRepository;

	@Override
	public PessoaResponse criaPessoa(PessoaRequest pessoaRequest) {
		log.info("[inicia] PessoaApplicationService - criaPessoa");
		Pessoa pessoa = pessoaRepository.salva(new Pessoa(pessoaRequest));
		log.info("[finaliza] PessoaApplicationService - criaPessoa");
		return PessoaResponse.builder()
				.idPessoa(pessoa.getIdPessoa())
				.build();
	}

	@Override
	public List<PessoaListResponse> buscaTodosPessoas() {
		log.info("[inicia] PessoaApplicationService - buscaTodosPessoas");
		List<Pessoa> pessoas = pessoaRepository.buscaTodosPessoas();
		log.info("[finaliza] PessoaApplicationService - buscaTodosPessoas");
		return PessoaListResponse.converte(pessoas);
	}

	@Override
	public PessoaDetalhadaResponse buscaPessoaAtravesId(UUID idPessoa) {
		log.info("[inicia] PessoaApplicationService - buscaPessoaAtravesId");
		Pessoa pessoa = pessoaRepository.buscaPessoaAtravesId(idPessoa);
		log.info("[finaliza] PessoaApplicationService - buscaPessoaAtravesId");
		return new PessoaDetalhadaResponse(pessoa);
	}

	@Override
	public void patchEditaPessoa(UUID idPessoa, @Valid PessoaRequest pessoaRequest) {
		log.info("[inicia] PessoaApplicationService - patchEditaPessoa");
		Pessoa pessoa = pessoaRepository.buscaPessoaAtravesId(idPessoa);
		pessoa.edita(pessoaRequest);
		pessoaRepository.salva(pessoa);
		log.info("[finaliza] PessoaApplicationService - patchEditaPessoa");
		
	}

	@Override
	public void deletaPessoaAtravesId(UUID idPessoa) {
		log.info("[inicia] PessoaApplicationService - deletaPessoaAtravesId");
		log.info("[finaliza] PessoaApplicationService - deletaPessoaAtravesId");
		
	}
}
