package com.ecart.ecartproductsvc.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ecart.ecartproductsvc.model.Product;

public interface ProductRepository extends CrudRepository<Product, String>  {

	List<Product> findByCategory(String category);
	
	@Query(value = "SELECT p FROM product p where p.category = :category  and p.price != :price")
	List<Product> findByCategoryandPrice(@Param("category") String category, @Param("price") BigDecimal price);
	
	List<Product> findByCompany(String company);
	
	@Query(value = "SELECT p FROM product p where p.company = :company and p.price != :price")
	List<Product> findByCompanyandPrice(@Param("company") String company, @Param("price") BigDecimal price);
	
	@Query(value = "SELECT p.productcode, p.productdescription, p.color, p.company, p.category, p.stock, (p.price - ((p.price*p.discount)/100)) as price, p.discount FROM product p where p.category = :category  and p.discount > 0")
	List<Product> findDiscountedProducts(@Param("category") String category);
	
}
