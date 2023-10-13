package br.com.attornatus.cadastropessoas.endereco.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.attornatus.cadastropessoas.endereco.application.api.EnderecoRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private UUID idEndereco;
	@NotNull
	@Column(name = "idPessoa", updatable = false)
	private UUID idPessoa;
	private String logradouro;
	private String cep;
	private String numero;
	
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraDaUltimaAlteracao;
	
	public Endereco(UUID idPessoa, @Valid EnderecoRequest enderecoRequest) {
		this.idPessoa = idPessoa;
		this.logradouro = enderecoRequest.getLogradouro();
		this.cep = enderecoRequest.getCep();
		this.numero = enderecoRequest.getNumero();
		this.dataHoraDoCadastro = LocalDateTime.now();
	}
}
