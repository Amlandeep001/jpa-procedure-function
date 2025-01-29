package com.org.jpa.service;

import org.springframework.stereotype.Service;

import com.org.jpa.entity.Product;
import com.org.jpa.repository.ProductRepository;

@Service
public class ProductService
{
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository)
	{
		this.productRepository = productRepository;
	}

	public Product updateStockQuantity(Integer productId, Integer quantity)
	{
		productRepository.updateStock(productId, quantity);
		return productRepository.findById(productId).get();
	}

	public Double calculateProductPrice(int id)
	{
		return productRepository.getTotalPrice(id);
	}
}
