package br.com.attornatus.cadastropessoas.pessoa.application.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.attornatus.cadastropessoas.pessoa.domain.EnderecoPrincipal;
import br.com.attornatus.cadastropessoas.pessoa.domain.Pessoa;
import lombok.Value;

@Value
public class PessoaDetalhadaResponse {
	private UUID idPessoa;
	private String nomeCompleto;
	private LocalDate dataNascimento;
	private EnderecoPrincipal enderecoPrincipal;
	private LocalDateTime dataHoraDoCadastro;
	
	public PessoaDetalhadaResponse(Pessoa pessoa) {
		this.idPessoa = pessoa.getIdPessoa();
		this.nomeCompleto = pessoa.getNomeCompleto();
		this.dataNascimento = pessoa.getDataNascimento();
		this.enderecoPrincipal = pessoa.getEnderecoPrincipal();
		this.dataHoraDoCadastro = pessoa.getDataHoraDoCadastro();
	}
}
