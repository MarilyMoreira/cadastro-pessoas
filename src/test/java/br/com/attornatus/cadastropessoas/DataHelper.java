package br.com.attornatus.cadastropessoas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.attornatus.cadastropessoas.pessoa.application.api.PessoaRequest;
import br.com.attornatus.cadastropessoas.pessoa.domain.EnderecoPrincipal;
import br.com.attornatus.cadastropessoas.pessoa.domain.Pessoa;

public class DataHelper {

	public static Pessoa getTestePessoa() {
		return new Pessoa(criaPessoaRequest());
	}
	
	public static PessoaRequest criaPessoaRequest() {
		String nomeCompleto = "Marily Santos Moreira";
        LocalDate dataNascimento = LocalDate.of(1984, 8, 26);
		EnderecoPrincipal enderecoPrincipal = new EnderecoPrincipal("Rua Grapiá", "45821393", "280");
		return new PessoaRequest(nomeCompleto, dataNascimento, enderecoPrincipal);
	}	
	
	public static List<Pessoa> criaListaPessoas() {
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(getTestePessoa());
		pessoas.add(getTestePessoa());
		return pessoas;
	}	
}
