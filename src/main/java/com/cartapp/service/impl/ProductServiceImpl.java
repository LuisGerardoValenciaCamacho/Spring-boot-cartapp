package com.cartapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cartapp.exception.ResourceNotFound;
import com.cartapp.model.Product;
import com.cartapp.repository.ProductRepository;
import com.cartapp.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	
	ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product find(long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFound(Product.class, "Identificador no encontrado"));
		return product;
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product create(Product product) {
		Product newProduct = new Product(product.getName(), product.getDescription(), product.getPrice());
		return productRepository.saveAndFlush(newProduct);
	}

	public Product update(Long id, Product product) {
		Product oldProduct = find(id);
		oldProduct.setName(product.getName());
		oldProduct.setDescription(product.getDescription()); 
		oldProduct.setPrice(product.getPrice());
		return productRepository.saveAndFlush(oldProduct);
	}

	public void delete(long id) {
		Product product = find(id);
		productRepository.delete(product);
	}

}
