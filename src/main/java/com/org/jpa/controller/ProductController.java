package com.org.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.jpa.entity.Product;
import com.org.jpa.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController
{
	private final ProductService service;

	public ProductController(ProductService service)
	{
		this.service = service;
	}

	@PutMapping("/update/{productId}/{quantity}")
	public Product updateInventoryStock(@PathVariable Integer productId,
			@PathVariable Integer quantity)
	{
		return service.updateStockQuantity(productId, quantity);
	}

	@GetMapping("/total-price/{productId}")
	public Double getTotalPrice(@PathVariable Integer productId)
	{
		return service.calculateProductPrice(productId);
	}
}
