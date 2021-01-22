package br.com.compasso.api.desafiotecnico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.api.desafiotecnico.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	Optional<Cidade> findByNome(String nome);
	
	Optional<Cidade> findByEstado(String estado);
}
