package br.com.compasso.api.desafiotecnico.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.compasso.api.desafiotecnico.enums.SexoEnum;

@Entity
public class Cliente {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeCompleto;
	
	@Enumerated(EnumType.STRING)
	private SexoEnum sexo;
	
	private String nascimento;
	
	private Integer idade;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cidade_id")
	private Cidade cidade;
	
	public Cliente() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nomeCompleto=" + nomeCompleto + ", sexo=" + sexo + ", nascimento=" + nascimento
				+ ", idade=" + idade + ", cidade=" + cidade + "]";
	}

	public boolean valido() {
		if (nomeCompleto != null && nascimento != null && idade != null && idade > 0 && cidade != null)
			return true;
		
		return false;
	}
}
