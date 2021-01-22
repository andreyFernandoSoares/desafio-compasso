package br.com.compasso.api.desafiotecnico.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.compasso.api.desafiotecnico.model.Cidade;
import br.com.compasso.api.desafiotecnico.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;

	public ResponseEntity<?> gravar(Cidade cidade) {
		try {
			if (cidade.valida()) {
				Cidade cidadeCriada = cidadeRepository.save(cidade);
				
				if (cidadeCriada != null) 
					return ResponseEntity.ok(cidadeCriada);
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao criar cidade!");
		}
		
		return ResponseEntity.badRequest().body("Erro ao criar cidade. Faltam dados!");
	}
	
	public ResponseEntity<?> buscaPeloNome(String nome) {
		try {
			Optional<Cidade> cidade = cidadeRepository.findByNome(nome);
			
			if (cidade.isPresent())
				return ResponseEntity.ok(cidade.get());
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Nome invalido!");
		}
		
		return ResponseEntity.badRequest().body("Nome invalido!");
	}
	
	public ResponseEntity<?> buscaPeloEstado(String estado) {
		try {
			Optional<Cidade> cidade = cidadeRepository.findByEstado(estado);
			
			if (cidade.isPresent())
				return ResponseEntity.ok(cidade.get());
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Estado invalido!");
		}
		
		return ResponseEntity.badRequest().body("Estado invalido!");
	}
	
	public Boolean validaCidade(Cidade cidade) {
		Optional<Cidade> cidadePorEstado = cidadeRepository.findByEstado(cidade.getEstado());
		
		if (cidadePorEstado.isPresent()) {
			Optional<Cidade> cidadePorNome = cidadeRepository.findByNome(cidade.getNome());
			
			if (cidadePorNome.isPresent())
				return true;
		}
		
		return false;
	}
}
