package br.com.compasso.api.desafiotecnico.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.api.desafiotecnico.model.Cliente;
import br.com.compasso.api.desafiotecnico.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> gravar(@RequestBody Cliente cliente) {
		System.out.println(cliente);
		return clienteService.gravar(cliente);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPeloId(@PathVariable Long id) {
		return clienteService.buscaPeloId(id);
	}
	
	@GetMapping
	public ResponseEntity<?> buscarPeloNome(@RequestParam(required = false) String nome) {
		return clienteService.buscaPeloNome(nome);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> alterarNome(@PathVariable Long id, @RequestBody Cliente cliente) {
		return clienteService.alterarNome(id, cliente.getNomeCompleto());
	} 
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> alterarNome(@PathVariable Long id) {
		return clienteService.deletar(id);
	} 
}
