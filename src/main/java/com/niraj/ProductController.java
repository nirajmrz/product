package com.niraj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProductController {

	@Autowired
	private ProductRepository repo;
	
	@GetMapping("/list")
	public List<Product> listProduct(){
		return repo.findAll();
	}
	
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable (name="id") int id) {
		return repo.findById(id).orElse(null);
	}
	
	@RequestMapping(value="/addProduct", method =RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) {
		return repo.save(product);
	}
	
	
	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable (name="id") int id) {
		repo.deleteById(id);
		return "Product Deleted";
	}
	
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		return repo.save(product);
	}
	
	
}
