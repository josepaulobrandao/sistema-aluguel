package oi.github.josepaulo.data.datasources;

import org.springframework.data.jpa.repository.JpaRepository;

import oi.github.josepaulo.data.models.ProductModel;

public interface JpaProductRepository extends JpaRepository<ProductModel, String>{

}
