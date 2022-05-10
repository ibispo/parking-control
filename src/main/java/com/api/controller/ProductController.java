package com.api.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.ProductModel;
import com.api.repository.IProductRepository;


@RestController
public class ProductController {

	@Autowired
	private IProductRepository productRepository;
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductModel>> getAllProducts() {
		
		List<ProductModel> prdList = productRepository.findAll();
		if ( prdList.isEmpty() ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			prdList.stream()
				.forEach(p -> p.add(linkTo(methodOn(ProductController.class)
										.getOneProduct(p.getId())).withSelfRel()));
			return new ResponseEntity<List<ProductModel>>(prdList, HttpStatus.OK);
		}
		
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<ProductModel> getOneProduct(@PathVariable(value="id") Long id) {

		Optional<ProductModel> prd = productRepository.findById(id);
		if (!prd.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			prd.get().add(linkTo(methodOn(ProductController.class)
								.getAllProducts()).withRel("List of Products"));
			return new ResponseEntity<ProductModel>(prd.get(), HttpStatus.OK);
		}

	}

	@PostMapping("/product")
	public ResponseEntity<ProductModel> saveProduct( @RequestBody @Valid ProductModel prd ) {
		return new ResponseEntity<ProductModel>(productRepository.save(prd), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/product")
	public ResponseEntity<?> deleteProduct(@PathVariable(value="id") Long id) {
		Optional<ProductModel> prd = productRepository.findById(id);
		if ( !prd.isPresent() ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			productRepository.delete(prd.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	
	
	
	
	
	
}
