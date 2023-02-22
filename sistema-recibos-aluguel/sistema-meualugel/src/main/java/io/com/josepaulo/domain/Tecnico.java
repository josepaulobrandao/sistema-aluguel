package io.com.josepaulo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.com.josepaulo.domain.dtos.TecnicoDTO;
import io.com.josepaulo.domain.enums.PerfilUsuario;

@Entity
public class Tecnico extends Pessoa {
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@OneToMany(mappedBy = "tecnico")
	private List<Chamado> chamados = new ArrayList<>();

	public Tecnico() {
		super();
		addPerfil(PerfilUsuario.TECNICO);
	}

	public Tecnico(Integer id, String nome, String email, String cpf, String senha) {
		super(id, nome, email, cpf, senha);
	}

	public List<Chamado> getChamados() {
		return chamados;
	}
 
	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	
	public Tecnico(TecnicoDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.cpf = obj.getCpf();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
	}

	
}
