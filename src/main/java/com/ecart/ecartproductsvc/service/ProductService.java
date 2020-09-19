package com.ecart.ecartproductsvc.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.ecartproductsvc.dao.ProductRepository;
import com.ecart.ecartproductsvc.model.Product;

@Service
public class ProductService{
	
	@Autowired
	ProductRepository productrepository;
	
	/**
	 * 1. Get the list of all the products across all the categories
	 * 2. Get the available stock details across products. This should consider the dummy orders placed and return stocks accordingly. 
	 * 
	 * @return
	 */
	public List<Product> retrieveProducts() {
				
		List<Product> products = new ArrayList<Product>();
				
		productrepository.findAll().forEach(products::add);
				
		return products;
	}
	
	/**
	 * Get the list of all the products by category or of a price less than or greater than a specified price for that product
	 * @param category
	 * @param price
	 * @return
	 */
	public List<Product> retrieveProductByCategory(String category, BigDecimal price) {
			
		List<Product> products = new ArrayList<Product>();
		
		if(null == price) {
			
			products = productrepository.findByCategory(category);
		}else {
			
			products = productrepository.findByCategoryandPrice(category, price);
		}
		
		return products;
	}
	
	/**
	 * Get the list of all the products by company or of a price less than or greater than a specified price for that company
	 * @param company
	 * @param price
	 * @return
	 */
	public List<Product> retrieveProductByCompany(String company, BigDecimal price) {
		
		List<Product> products = new ArrayList<Product>();
		
		if(null == price) {
			
			products = productrepository.findByCompany(company);
		}else {
			
			products = productrepository.findByCompanyandPrice(company, price);
		}
        
		return products;
	}
	
	/**
	 * Get the discounted price of all the products by category
	 * @param category
	 * @return
	 */
	public List<Product> retrieveDiscountedProducts(String category) {
				
		List<Product> products =  productrepository.findDiscountedProducts(category);
        
		return products;
	}
	

	
	
}
  
  