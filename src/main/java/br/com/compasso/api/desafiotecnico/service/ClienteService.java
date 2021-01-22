package br.com.compasso.api.desafiotecnico.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.compasso.api.desafiotecnico.model.Cliente;
import br.com.compasso.api.desafiotecnico.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CidadeService cidadeService;

	public ResponseEntity<?> gravar(Cliente cliente) {
		try {
			if (cliente.valido()) {
				if (cidadeService.validaCidade(cliente.getCidade())) {
					Cliente clienteCriado = clienteRepository.save(cliente);
					
					if (clienteCriado != null) 
						return ResponseEntity.ok(clienteCriado);
				} else 
					return ResponseEntity.badRequest().body("Erro ao criar cidade não existe");
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.badRequest().body("Erro ao criar cliente. Faltam dados!");
	}
	
	public ResponseEntity<?> buscaPeloId(Long id) {
		try {
			Optional<Cliente> cliente = clienteRepository.findById(id);
			
			if (cliente.isPresent())
				return ResponseEntity.ok(cliente.get());
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Id invalido!");
		}
		
		return ResponseEntity.badRequest().body("Id invalido!");
	}

	public ResponseEntity<?> buscaPeloNome(String nome) {
		try {
			Optional<Cliente> cliente = clienteRepository.findByNomeCompleto(nome);
			
			if (cliente.isPresent())
				return ResponseEntity.ok(cliente.get());
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Nome invalido!");
		}
		
		return ResponseEntity.badRequest().body("Nome invalido!");
	}
	
	public ResponseEntity<?> deletar(Long id) {
		try {
			Optional<Cliente> cliente = clienteRepository.findById(id);
			
			if (cliente.isPresent()) {
				clienteRepository.deleteById(id);
				return ResponseEntity.ok("Deletado com sucesso!");
			} else 
				return ResponseEntity.badRequest().body("Cliente solicitado para a deleção não existe!");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao deletar!");
		}
	}
	
	public ResponseEntity<?> alterarNome(Long id, String nome) {
		try {
			Optional<Cliente> cliente = clienteRepository.findById(id);
			
			if (cliente.isPresent()) {
				Cliente novoCliente = cliente.get();
				novoCliente.setNomeCompleto(nome);
				clienteRepository.save(novoCliente);
				return ResponseEntity.ok(novoCliente);
			} else {
				return ResponseEntity.badRequest().body("Não existe cliente com este ID!");
			}
	
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao alterar nome!");
		}
	}
}
