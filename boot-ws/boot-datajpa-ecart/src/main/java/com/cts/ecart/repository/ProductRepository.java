package com.cts.ecart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.cts.ecart.entity.Product;
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	// list all products by product title
	List<Product> findByProductTitle(String name);
	
	List<Product> findByProductTitleLike(String name);
	
	// display all products by price range?
	List<Product> findByPriceInfoPriceGreaterThanEqual(double price);
	// display all products by price range?
    List<Product> findByPriceInfoPriceLessThanEqual(double price);
	// display all products by price range?
	List<Product> findByPriceInfoPriceBetween(double start,double end);
	
	// Query annotation is used to write custom methods with HQL / JPQL
	// Positional parameters
	@Query(name = "q1",value = "from com.cts.ecart.entity.Product p where p.priceInfo.price >=?1")
	List<Product> filterPrice(double price);
	
	// named parameters
	@Query(name = "q2",value = "from com.cts.ecart.entity.Product p where p.priceInfo.price <=:price")
	List<Product> filterPriceV1(double price);
	
	
	// named parameters
	@Query(name = "q3",value = "from com.cts.ecart.entity.Product p where p.priceInfo.price <=:prodPrice")
	List<Product> filterPriceV2(@Param("prodPrice") double price);

}
