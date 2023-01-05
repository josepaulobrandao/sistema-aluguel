package oi.github.josepaulo.data.repositories;

import java.util.List;

import oi.github.josepaulo.data.datasources.ProductDatasourceLocal;
import oi.github.josepaulo.data.models.ProductModel;
import oi.github.josepaulo.domain.entities.Product;
import oi.github.josepaulo.domain.repositories.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {
	
	final ProductDatasourceLocal datasourceLocal;
	
	public ProductRepositoryImpl(ProductDatasourceLocal datasourceLocal) {
		this.datasourceLocal = datasourceLocal;
	}

	@Override
	public void createProduct(Product product) {
		ProductModel productModel = new ProductModel();
		datasourceLocal.createProduct(productModel.toProductModel(product));
	}

	@Override
	public void deleteProduct(int id) {
		datasourceLocal.deleteProduct(id);
	}

	@Override
	public Product getProduct(int id) {
		ProductModel productModel = new ProductModel();
		return productModel.toProduct(datasourceLocal.getProduct(id));
	}

	@Override
	public List<Product> getProducts() {
		
		ProductModel productModel = new ProductModel();
		productModel.toProductList(datasourceLocal.getProducts());
		
		return null;
	}
	
}
