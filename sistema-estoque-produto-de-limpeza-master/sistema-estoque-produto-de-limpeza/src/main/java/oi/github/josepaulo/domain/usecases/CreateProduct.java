package oi.github.josepaulo.domain.usecases;

import oi.github.josepaulo.domain.entities.Product;
import oi.github.josepaulo.domain.repositories.ProductRepository;

public class CreateProduct {
	
	final ProductRepository productRepository;
	
	public CreateProduct(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}	
	
	public void call(Product product) {
		productRepository.createProduct(product);
	}
	
}
