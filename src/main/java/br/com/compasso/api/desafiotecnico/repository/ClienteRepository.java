package br.com.compasso.api.desafiotecnico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.api.desafiotecnico.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Optional<Cliente> findByNomeCompleto(String nome);
}
