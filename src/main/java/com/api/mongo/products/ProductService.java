package com.api.mongo.products;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.api.mongo.utils.BusinessException;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(String id) {
		 Optional<Product> result = productRepository.findById(id);
		 return result.isPresent() ? result.get() : null;
	}

	@Override
	public List<Product> search(Product example) {
		List<Product> result = productRepository.findAll( Example.of(example) );
		 return result;
	}

	@Override
	public Product save(Product entity) {
		return productRepository.insert(entity);
	}

	@Override
	public Product update(Product entity) {
		return productRepository.save(entity);
	}

	@Override
	public void delete(String id) {
		Optional<Product> entity = productRepository.findById(id);
		
		if(!entity.isPresent()) {
			throw new BusinessException("Product id "+id+" not found");
		}
		productRepository.delete(entity.get());
	}

	@Override
	public Product getMostExpensive() {
		 List<Product> all = productRepository.findAll(Sort.by("price").descending());
		return all!= null ? all.get(0) : null;
	}	
}
