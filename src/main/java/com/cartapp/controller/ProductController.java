package com.cartapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cartapp.model.Product;
import com.cartapp.service.IProductService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("http://localhost:5173")
public class ProductController {
	
	IProductService IProductService;
	
	public ProductController(IProductService productService) {
		this.IProductService = productService;
	}
	
	@GetMapping("/all")
	public List<Product> getAll() {
		List<Product> listProducts = new ArrayList<Product>();
		listProducts = IProductService.findAll();
		return listProducts;
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") Long id) {
		Product product = IProductService.find(id);
		return product;
	}
	
	@PostMapping("/create")
	public Product createProduct (@RequestBody Product product) {
		Product newProduct = IProductService.create(product);
		return newProduct;
	}
	
	@PutMapping("/update/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		Product newProduct = IProductService.update(id, product);
		return newProduct;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable Long id) {
		IProductService.delete(id);
	}

}
