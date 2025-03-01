package com.cartapp.service;

import java.util.List;

import com.cartapp.model.Product;

public interface IProductService {
	
	Product find(long id);
	
	List<Product> findAll();
	
	Product create(Product product);
	
	Product update(Long id, Product product);
	
	void delete(long id);
}
