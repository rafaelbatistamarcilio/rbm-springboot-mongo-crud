package com.api.mongo.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products")
public class ProductRestController {

	@Autowired
	private IProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		return new ResponseEntity<>( productService.findAll(), HttpStatus.OK );
	}

	@GetMapping("{id}")
	public ResponseEntity<Product> findById(@PathVariable("id") String id) {
		return new ResponseEntity<>( productService.findById(id), HttpStatus.OK );
	}

	@PostMapping("/search")
	public ResponseEntity<List<Product>> search( @RequestBody Product example) {
		return new ResponseEntity<>( productService.search(example), HttpStatus.OK );
	}

	@PostMapping
	public ResponseEntity<Product> save( @RequestBody Product entity) {
		return new ResponseEntity<>( productService.save(entity), HttpStatus.OK );
	}

	@PutMapping("{id}")
	public ResponseEntity<Product> update(@PathVariable("id") String id, @RequestBody Product entity){
		return new ResponseEntity<>( productService.update(entity), HttpStatus.OK );
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		productService.delete(id);
		return new ResponseEntity<>( "Product id "+id+" deleted", HttpStatus.OK );
	}
}
