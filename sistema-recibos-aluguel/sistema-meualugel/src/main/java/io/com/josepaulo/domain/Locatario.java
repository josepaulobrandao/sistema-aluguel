package io.com.josepaulo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.com.josepaulo.domain.dtos.LocatarioDTO;
import io.com.josepaulo.domain.enums.PerfilUsuario;

@Entity
public class Locatario extends Pessoa {
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@OneToMany(mappedBy = "locatario")
	private List<Chamado> chamados = new ArrayList<>();

	public Locatario() {
		super();
		addPerfil(PerfilUsuario.LOCATARIO);
	}

	public Locatario(Integer id, String nome, String email, String cpf, String senha) {
		super(id, nome, email, cpf, senha);
	}
	
	
	public Locatario(LocatarioDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.cpf = obj.getCpf();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	
	
}
