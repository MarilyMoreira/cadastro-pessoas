package br.com.attornatus.cadastropessoas.pessoa.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import br.com.attornatus.cadastropessoas.DataHelper;
import br.com.attornatus.cadastropessoas.handler.APIException;
import br.com.attornatus.cadastropessoas.pessoa.application.api.PessoaRequest;
import br.com.attornatus.cadastropessoas.pessoa.application.repository.PessoaRepository;
import br.com.attornatus.cadastropessoas.pessoa.domain.Pessoa;

@ExtendWith(MockitoExtension.class)
class PessoaApplicationServiceTest {
	@InjectMocks
	private PessoaApplicationService pessoaApplicationService;
	@Mock
	private PessoaRepository pessoaRepository;
	
	@Test
	void deveCriarPessoa() {
		PessoaRequest pessoaRequest = DataHelper.criaPessoaRequest();
		Pessoa pessoa = DataHelper.getTestePessoa();
		when(pessoaRepository.salva(any(Pessoa.class))).thenReturn(pessoa);
		pessoaApplicationService.criaPessoa(pessoaRequest);
		verify(pessoaRepository, times(1)).salva(any(Pessoa.class));
	}	
	
	@Test
	void deveBuscarTodasPessoas() {
		List<Pessoa> pessoas = DataHelper.criaListaPessoas();
		when(pessoaRepository.buscaTodasPessoas()).thenReturn(pessoas);
		pessoaApplicationService.buscaTodasPessoas();
		verify(pessoaRepository, times(1)).buscaTodasPessoas();
		assertEquals(pessoas.size(), 2);
	}	
	
	@Test
	void deveBuscarPessoaPorId() {
		Pessoa pessoa = DataHelper.getTestePessoa();
		when(pessoaRepository.buscaPessoaAtravesId(pessoa.getIdPessoa())).thenReturn(pessoa);
		pessoaApplicationService.buscaPessoaAtravesId(pessoa.getIdPessoa());
		verify(pessoaRepository, times(1)).buscaPessoaAtravesId(pessoa.getIdPessoa());
	}
	
	@Test
	void deveRetornarExceptionBuscarPessoaPorId() {
		Pessoa pessoa = DataHelper.getTestePessoa();
		when(pessoaRepository.buscaPessoaAtravesId(pessoa.getIdPessoa()))
		.thenThrow(APIException.build(HttpStatus.NOT_FOUND, "Pessoa não encontrada!"));
		APIException e = assertThrows(APIException.class, () -> pessoaApplicationService.buscaPessoaAtravesId(pessoa.getIdPessoa()));
		assertEquals(HttpStatus.NOT_FOUND, e.getStatusException());
		assertEquals("Pessoa não encontrada!", e.getMessage());
	}
	
	@Test
	void deveEditarPessoaPorId() {
		Pessoa pessoa = DataHelper.getTestePessoa();
		PessoaRequest pessoaRequest = DataHelper.criaPessoaRequest();
		when(pessoaRepository.buscaPessoaAtravesId(pessoa.getIdPessoa())).thenReturn(pessoa);
		pessoaApplicationService.patchEditaPessoa(pessoa.getIdPessoa(), pessoaRequest);	
		verify(pessoaRepository, times(1)).buscaPessoaAtravesId(pessoa.getIdPessoa());
		verify(pessoaRepository, times(1)).salva(pessoa);
	}
	
	@Test
	void deveDeletarPessoaPorId() {
		Pessoa pessoa = DataHelper.getTestePessoa();
		when(pessoaRepository.buscaPessoaAtravesId(pessoa.getIdPessoa())).thenReturn(pessoa);
		pessoaApplicationService.deletaPessoaAtravesId(pessoa.getIdPessoa());	
		verify(pessoaRepository, times(1)).buscaPessoaAtravesId(pessoa.getIdPessoa());
		verify(pessoaRepository, times(1)).deleta(pessoa);
	}
}
