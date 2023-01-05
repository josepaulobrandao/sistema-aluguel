package oi.github.josepaulo.data.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import oi.github.josepaulo.data.models.ProductRequestModel;
import oi.github.josepaulo.data.models.ProductResponseModel;
import oi.github.josepaulo.domain.usecases.CreateProduct;


@RestController
public class ProductController {
	final CreateProduct createProduct;
	
	public ProductController(CreateProduct createProduct) {
		this.createProduct = createProduct;
		
	}
	
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductResponseModel> create(@RequestBody ProductRequestModel entity) {

		try {
			
			createProduct.call(ProductRequestModel.toProduct(entity));
			return new ResponseEntity<ProductResponseModel>
		   (new ProductResponseModel
		   (HttpStatus.OK.value(),
			HttpStatus.OK.name()),
			HttpStatus.OK);
			
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
	
}
