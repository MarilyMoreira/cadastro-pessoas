package br.com.attornatus.cadastropessoas.endereco.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.attornatus.cadastropessoas.endereco.application.api.EnderecoAlteracaoRequest;
import br.com.attornatus.cadastropessoas.endereco.application.api.EnderecoPessoaDetalhadoResponse;
import br.com.attornatus.cadastropessoas.endereco.application.api.EnderecoPessoaListResponse;
import br.com.attornatus.cadastropessoas.endereco.application.api.EnderecoRequest;
import br.com.attornatus.cadastropessoas.endereco.application.api.EnderecoResponse;
import br.com.attornatus.cadastropessoas.endereco.domain.Endereco;
import br.com.attornatus.cadastropessoas.pessoa.application.api.PessoaListResponse;
import br.com.attornatus.cadastropessoas.pessoa.application.service.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class EnderecoApplicationService implements EnderecoService {
	private final PessoaService pessoaService;
	private final EnderecoRepository enderecoRepository;

	@Override
	public EnderecoResponse criaEndereco(UUID idPessoa, @Valid EnderecoRequest enderecoRequest) {
		log.info("[inicia] EnderecoApplicationService - criaEndereco");
		pessoaService.buscaPessoaAtravesId(idPessoa);
		Endereco endereco = enderecoRepository.salvaEndereco(new Endereco(idPessoa, enderecoRequest));
		log.info("[finaliza] EnderecoApplicationService - criaEndereco");
		return new EnderecoResponse(endereco.getIdEndereco());
	}

	@Override
	public List<EnderecoPessoaListResponse> buscaEnderecosDaPessoaComId(UUID idPessoa) {
		log.info("[inicia] EnderecoApplicationService - buscaEnderecosDaPessoaComId");
		pessoaService.buscaPessoaAtravesId(idPessoa);
		List<Endereco> enderecosDaPessoa = enderecoRepository.buscaEnderecosDaPessoaAtravesId(idPessoa);
		List<PessoaListResponse> listarEnderecosPessoa = pessoaService.buscaTodosPessoas();
		log.info("[finaliza] EnderecoApplicationService - buscaEnderecosDaPessoaComId");
		return EnderecoPessoaListResponse.converte(enderecosDaPessoa, listarEnderecosPessoa);
	}

	@Override
	public EnderecoPessoaDetalhadoResponse buscaEnderecoDaPessoaComId(UUID idPessoa, UUID idEndereco) {
		log.info("[inicia] EnderecoApplicationService - buscaEnderecoDaPessoaComId");
		pessoaService.buscaPessoaAtravesId(idPessoa);
		Endereco endereco = enderecoRepository.buscaEnderecoAtravesDoId(idEndereco);
		log.info("[finaliza] EnderecoApplicationService - buscaEnderecoDaPessoaComId");
		return new EnderecoPessoaDetalhadoResponse(endereco);
	}

	@Override
	public void deletaEnderecoDaPessoaAtravesId(UUID idPessoa, UUID idEndereco) {
		log.info("[inicia] EnderecoApplicationService - deletaEnderecoDaPessoaAtravesId");
		pessoaService.buscaPessoaAtravesId(idPessoa);
		Endereco endereco = enderecoRepository.buscaEnderecoAtravesDoId(idEndereco);
		enderecoRepository.deletaEndereco(endereco);
		log.info("[finaliza] EnderecoApplicationService - deletaEnderecoDaPessoaAtravesId");
		
	}

	@Override
	public void alteraEnderecoDaPessoaComId(UUID idPessoa, UUID idEndereco, EnderecoAlteracaoRequest enderecoAlteracaoRequest) {
		log.info("[inicia] EnderecoApplicationService - alteraEnderecoDaPessoaComId");
		pessoaService.buscaPessoaAtravesId(idPessoa);
		Endereco endereco = enderecoRepository.buscaEnderecoAtravesDoId(idEndereco);
		endereco.altera(enderecoAlteracaoRequest);
		enderecoRepository.salvaEndereco(endereco);
		log.info("[finaliza] EnderecoApplicationService - alteraEnderecoDaPessoaComId");
		
	}
}
