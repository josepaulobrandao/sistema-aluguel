package oi.github.josepaulo.domain.repositories;

import java.util.List;

import oi.github.josepaulo.domain.entities.Product;

public interface ProductRepository {

	public void createProduct(Product product);
	public void deleteProduct(int id);
	Product getProduct(int id);
	public List<Product> getProducts();
	
	
}
