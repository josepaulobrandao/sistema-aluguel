package io.com.josepaulo.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.com.josepaulo.domain.enums.PerfilUsuario;

@Entity
public abstract class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) /*chave primaria*/
	protected Integer id;
	protected String nome;
	@Column(unique = true)
	protected String email;
	/*@CPF*/
	@Column(unique = true)
	protected String cpf;
	protected String senha;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	protected Set<Integer> perfis = new HashSet<>();
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();
	
	
	public Pessoa() {
		super();
		addPerfil(PerfilUsuario.LOCATARIO);
	}


	public Pessoa(Integer id, String nome, String email, String cpf, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		addPerfil(PerfilUsuario.LOCATARIO);

		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Set<PerfilUsuario> getPerfis() {
		return perfis.stream().map(x -> PerfilUsuario.toEnum(x)).collect(Collectors.toSet());
	}


	public void addPerfil(PerfilUsuario perfil) {
		this.perfis.add(perfil.getCodigo());
	}


	public LocalDate getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}
	

	
}
