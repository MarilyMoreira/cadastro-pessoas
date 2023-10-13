package br.com.attornatus.cadastropessoas.endereco.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.attornatus.cadastropessoas.endereco.domain.Endereco;

public interface EnderecoSpringDataJPARepository extends JpaRepository<Endereco, UUID>{
	List<Endereco> findByIdPessoa(UUID idPessoa);
	void delete(Endereco endereco);
}
