package br.com.attornatus.cadastropessoas.endereco.application.api;

import java.util.List;
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

	@Override
	public List<EnderecoPessoaListResponse> getEnderecosDaPessoaComId(UUID idPessoa) {
		log.info("[inicia] EnderecoController - getEnderecosDoClienteComId");
		log.info("[idPessoa] {}", idPessoa);
		List<EnderecoPessoaListResponse> enderecosDaPessoa = enderecoService.buscaEnderecosDaPessoaComId(idPessoa);
		log.info("[finaliza] EnderecoController - getEnderecosDoClienteComId");
		return enderecosDaPessoa;
	}

	@Override
	public EnderecoPessoaDetalhadoResponse getEnderecoDaPessoaComId(UUID idPessoa, UUID idEndereco) {
		log.info("[inicia] EnderecoController - getEnderecoDaPessoaComId");
		log.info("[idPessoa] {} - [idEndereco] {}", idPessoa, idEndereco);
		EnderecoPessoaDetalhadoResponse endereco = enderecoService.buscaEnderecoDaPessoaComId(idPessoa, idEndereco);
		log.info("[finaliza] EnderecoController - getEnderecoDaPessoaComId");
		return endereco;
	}

	@Override
	public void deleteEnderecoDaPessoaComId(UUID idPessoa, UUID idEndereco) {
		log.info("[inicia] EnderecoController - deleteEnderecoDaPessoaComId");
		log.info("[idPessoa] {} - [idEndereco] {}", idPessoa, idEndereco);
		enderecoService.deletaEnderecoDaPessoaAtravesId(idPessoa, idEndereco);
		log.info("[finaliza] EnderecoController - deleteEnderecoDaPessoaComId");
		
	}

	@Override
	public void patchEndereco(UUID idPessoa, UUID idEndereco, @Valid EnderecoAlteracaoRequest enderecoAlteracaoRequest) {
		log.info("[inicia] EnderecoController - patchEndereco");
		log.info("[idPessoa] {} - [idEndereco] {}", idPessoa, idEndereco);
		enderecoService.alteraEnderecoDaPessoaComId(idPessoa, idEndereco, enderecoAlteracaoRequest);
		log.info("[finaliza] EnderecoController - patchEndereco");
		
	}

}
