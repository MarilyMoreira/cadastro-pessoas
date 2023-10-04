package br.com.attornatus.cadastropessoas.pessoa.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.attornatus.cadastropessoas.pessoa.domain.Pessoa;

public interface PessoaSpringDataJPARepository extends JpaRepository<Pessoa, UUID>{

}
