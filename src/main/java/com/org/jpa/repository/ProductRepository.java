package com.org.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.org.jpa.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
	@Procedure(name = "updateStockProcedure")
	void updateStock(Integer productId, Integer quantity);

	@Query(value = "SELECT get_total_price(:productId)", nativeQuery = true)
	Double getTotalPrice(int productId);
}
