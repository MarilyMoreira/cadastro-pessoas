package br.com.attornatus.cadastropessoas.pessoa.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.attornatus.cadastropessoas.pessoa.application.api.PessoaAlteracaoRequest;
import br.com.attornatus.cadastropessoas.pessoa.application.api.PessoaRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private UUID idPessoa;
	@NotBlank
	private String nomeCompleto;
	@NotNull
	private LocalDate dataNascimento;
	@Embedded
	private Endereco endereco;
	
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraDaUltimaAlteracao;

	public Pessoa(PessoaRequest pessoaRequest) {
		this.nomeCompleto = pessoaRequest.getNomeCompleto();
		this.dataNascimento = pessoaRequest.getDataNascimento();
		this.endereco = pessoaRequest.getEndereco();
		this.dataHoraDoCadastro = LocalDateTime.now();
	}

	public void edita(PessoaAlteracaoRequest pessoaAlteracaoRequest) {
		this.nomeCompleto = pessoaAlteracaoRequest.getNomeCompleto();
		this.dataNascimento = pessoaAlteracaoRequest.getDataNascimento();
		this.endereco = pessoaAlteracaoRequest.getEndereco();
		this.dataHoraDoCadastro = LocalDateTime.now();
		
	}
}
