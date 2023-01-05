package oi.github.josepaulo.data.datasources.impl;

import java.util.List;
import java.util.Optional;

import oi.github.josepaulo.data.datasources.JpaProductRepository;
import oi.github.josepaulo.data.datasources.ProductDatasourceLocal;
import oi.github.josepaulo.data.models.ProductModel;

public class ProductDatasourcesLocalImpl implements ProductDatasourceLocal {
	final JpaProductRepository jpaProductRepository;
	
	public ProductDatasourcesLocalImpl(JpaProductRepository jpaProductRepository) {
		this.jpaProductRepository = jpaProductRepository;
		
	}

	@Override
	public void createProduct(ProductModel productModel) {
		jpaProductRepository.save(productModel);
		
	}

	@Override
	public void deleteProduct(int id) {
		jpaProductRepository.deleteById(Integer.toString(id));
		
	}

	@Override
	public ProductModel getProduct(int id) {
		Optional<ProductModel> op = jpaProductRepository.findById(Integer.toString(id));
		
		return op.get();
	}

	@Override
	public List<ProductModel> getProducts() {
		return jpaProductRepository.findAll();
	}


	
	
	
	
	
	
	
}
