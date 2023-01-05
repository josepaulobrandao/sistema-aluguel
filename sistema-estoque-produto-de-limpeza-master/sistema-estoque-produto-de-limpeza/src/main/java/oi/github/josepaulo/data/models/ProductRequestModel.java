package oi.github.josepaulo.data.models;

import java.util.Date;

import oi.github.josepaulo.domain.entities.Product;

public class ProductRequestModel {
	private Long id;
	private String nome;
	private String descricao;
	private Date dataCriacao;
	private int qtdMinima;
	private int qtdMaxima;
	
	public static Product toProduct(ProductRequestModel productModel) {
		Product product = new Product();
		product.setId(productModel.getId());
		product.setNome(productModel.getNome());
		product.setDescricao(productModel.getDescricao());
		product.setDataCriacao(productModel.getDataCriacao());
		product.setQtdMaxima(productModel.getQtdMaxima());
		product.setQtdMinima(productModel.getQtdMinima());
	
		return product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public int getQtdMinima() {
		return qtdMinima;
	}

	public void setQtdMinima(int qtdMinima) {
		this.qtdMinima = qtdMinima;
	}

	public int getQtdMaxima() {
		return qtdMaxima;
	}

	public void setQtdMaxima(int qtdMaxima) {
		this.qtdMaxima = qtdMaxima;
	}
	
	
	

}
