package br.com.attornatus.cadastropessoas.pessoa.application.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.attornatus.cadastropessoas.pessoa.domain.Endereco;
import br.com.attornatus.cadastropessoas.pessoa.domain.Pessoa;
import lombok.Value;

@Value
public class PessoaDetalhadoResponse {
	private UUID idPessoa;
	private String nomeCompleto;
	private LocalDate dataNascimento;
	private Endereco endereco;
	private LocalDateTime dataHoraDoCadastro;
	
	public PessoaDetalhadoResponse(Pessoa pessoa) {
		this.idPessoa = pessoa.getIdPessoa();
		this.nomeCompleto = pessoa.getNomeCompleto();
		this.dataNascimento = pessoa.getDataNascimento();
		this.endereco = pessoa.getEndereco();
		this.dataHoraDoCadastro = pessoa.getDataHoraDoCadastro();
	}
}
