package br.com.attornatus.cadastropessoas.endereco.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/pessoa/{idPessoa}/endereco")
public interface EnderecoAPI {
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	EnderecoResponse postEndereco(@PathVariable UUID idPessoa, 
			@Valid @RequestBody EnderecoRequest enderecoRequest);
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<EnderecoPessoaListResponse> getEnderecosDoClienteComId(@PathVariable UUID idPessoa);
	
	@GetMapping(value = "/{idEndereco}")
	@ResponseStatus(code = HttpStatus.OK)
	EnderecoPessoaDetalhadoResponse getEnderecoDoClienteComId(@PathVariable UUID idPessoa, 
			@PathVariable UUID idEndereco);
}
