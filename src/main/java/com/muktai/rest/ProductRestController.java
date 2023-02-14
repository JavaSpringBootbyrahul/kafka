package com.muktai.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.muktai.model.Product;
import com.muktai.publish.Publisher;

@RestController
@RequestMapping("/products")
public class ProductRestController 
{
	@Autowired
	private Publisher publish;
	@PostMapping("/save")
	public String sendProds(@RequestBody List<Product> Products)
	{
		publish.sendProds(Products);
		return "List of products sent successfully.....";
	}
	
	@GetMapping("/one")
	public String sendOneProd(
				@RequestParam String id,
				@RequestParam String name,
				@RequestParam double price
			)
	{
		Product p1=new Product(id, name, price);
		publish.sendOneProd(p1);
		return "Product sent successfully...";
	}
}
