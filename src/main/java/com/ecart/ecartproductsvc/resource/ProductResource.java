package com.ecart.ecartproductsvc.resource;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.ecartproductsvc.model.Product;
import com.ecart.ecartproductsvc.service.ProductService;

@RestController
public class ProductResource {
	
	@Autowired
	ProductService productservice;
	
	/**
	 * 1. Get the list of all the products across all the categories
	 * 2. Get the available stock details across products. This should consider the dummy orders placed and return stocks accordingly. 
	 * 
	 * @return
	 */
	@GetMapping(value="/products", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Product> retrieveProducts() {
				
		List<Product> products =  productservice.retrieveProducts();
        
		return products;
	}
	
	/**
	 * Get the list of all the products by category or of a price less than or greater than a specified price for that product
	 * @param category
	 * @param price
	 * @return
	 */
	@GetMapping(value="/products-by-category", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Product> retrieveProductByCategory(@RequestParam("category") String category, @RequestParam("price") BigDecimal price) {
			
		List<Product> products =  productservice.retrieveProductByCategory(category, price);
        
		return products;
	}
	
	/**
	 * Get the list of all the products by company or of a price less than or greater than a specified price for that company
	 * @param company
	 * @param price
	 * @return
	 */
	@GetMapping(value="/products-by-company", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Product> retrieveProductByCompany(@RequestParam("company") String company, @RequestParam("price") BigDecimal price) {
			
		List<Product> products =  productservice.retrieveProductByCompany(company, price);
        
		return products;
	}
	
	/**
	 * Get the discounted price of all the products by category
	 * @param category
	 * @return
	 */
	@GetMapping(value="/discount-products", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Product> retrieveDiscountProduct(@RequestParam("category") String category) {
				
		List<Product> products =  productservice.retrieveDiscountedProducts(category);
        
		return products;
	}
	
}
