package oi.github.josepaulo.data.models;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import oi.github.josepaulo.domain.entities.Product;

@Entity
@Table(name = "album")
public class ProductModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String descricao;
	private Date dataCriacao;
	private int qtdMinima;
	private int qtdMaxima;

	

	public Product toProduct(ProductModel productModel) {
		Product product = new Product();
		product.setId(productModel.getId());
		product.setNome(productModel.getNome());
		product.setDescricao(productModel.getDescricao());
		product.setDataCriacao(productModel.getDataCriacao());
		product.setQtdMinima(productModel.getQtdMinima());
		product.setQtdMaxima(productModel.getQtdMaxima());
	
		return product;
	}

	public ProductModel toProductModel(Product product) {
		ProductModel productModel = new ProductModel();
		productModel.setId(product.getId());
		productModel.setNome(product.getNome());
		productModel.setDescricao(product.getDescricao());
		productModel.setDataCriacao(product.getDataCriacao());
		productModel.setQtdMinima(product.getQtdMinima());
		productModel.setQtdMaxima(product.getQtdMaxima());
		return productModel;
	}

	public List<Product> toProductList(List<ProductModel> productModel) {
		return productModel.stream().map(temp -> {
			Product product = new Product();
			product.setId(temp.getId());
			product.setNome(temp.getNome());
			product.setDescricao(temp.getDescricao());
			product.setDataCriacao(temp.getDataCriacao());
			product.setQtdMinima(temp.getQtdMinima());
			product.setQtdMaxima(temp.getQtdMaxima());
		
			return product;
		}).collect(Collectors.toList());
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

	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", dataCriacao=" + dataCriacao
				+ ", qtdMinima=" + qtdMinima + ", qtdMaxima=" + qtdMaxima + "]";
	}
	

	
	
	
	
	
}
