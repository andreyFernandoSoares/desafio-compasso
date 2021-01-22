package br.com.compasso.api.desafiotecnico.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.api.desafiotecnico.model.Cidade;
import br.com.compasso.api.desafiotecnico.service.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeController {
	
	@Autowired 
	private CidadeService cidadeService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> gravar(@RequestBody Cidade cidade) {
		return cidadeService.gravar(cidade);
	}
	
	@GetMapping
	public ResponseEntity<?> buscarPeloNome(@RequestParam(required = false) String nome) {
		return cidadeService.buscaPeloNome(nome);
	}
	
	@GetMapping("/{uf}")
	public ResponseEntity<?> buscarPeloEstado(@PathVariable String uf) {
		return cidadeService.buscaPeloEstado(uf);
	}
}
