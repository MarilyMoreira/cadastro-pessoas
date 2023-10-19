package br.com.attornatus.cadastropessoas.endereco.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.attornatus.cadastropessoas.endereco.application.repository.EnderecoRepository;
import br.com.attornatus.cadastropessoas.endereco.domain.Endereco;
import br.com.attornatus.cadastropessoas.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2		
@RequiredArgsConstructor
public class EnderecoInfraRepository implements EnderecoRepository {
	private final EnderecoSpringDataJPARepository enderecoSpringDataJPARepository;
	
	@Override
	public Endereco salvaEndereco(Endereco endereco) {
		log.info("[inicia] EnderecoInfraRepository - salvaEndereco");
		enderecoSpringDataJPARepository.save(endereco);
		log.info("[finaliza] EnderecoInfraRepository - salvaEndereco");
		return endereco;
	}

	@Override
	public List<Endereco> buscaEnderecosDaPessoaAtravesId(UUID idPessoa) {
		log.info("[inicia] EnderecoInfraRepository - buscaEnderecosDaPessoaAtravesId");
		var enderecos = enderecoSpringDataJPARepository.findByIdPessoa(idPessoa);
		log.info("[finaliza] EnderecoInfraRepository - buscaEnderecosDaPessoaAtravesId");
		return enderecos;
	}

	@Override
	public Endereco buscaEnderecoAtravesDoId(UUID idEndereco) {
		log.info("[inicia] EnderecoInfraRepository - buscaEnderecoAtravesDoId");
		var endereco = enderecoSpringDataJPARepository.findById(idEndereco)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Endereço não encontrado para o idEndereco =" + idEndereco));
		log.info("[finaliza] EnderecoInfraRepository - buscaEnderecoAtravesDoId");
		return endereco;
	}

	@Override
	public void deletaEndereco(Endereco endereco) {
		log.info("[inicia] EnderecoInfraRepository - deletaEndereco");
		enderecoSpringDataJPARepository.delete(endereco);
		log.info("[finaliza] EnderecoInfraRepository - deletaEndereco");
	}

}
