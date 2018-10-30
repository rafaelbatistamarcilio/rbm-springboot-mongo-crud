package com.api.mongo.products;

import java.util.List;

public interface IProductService {
	List<Product> findAll();

	Product findById(String id);

	List<Product> search(Product example);

	Product save(Product entity);

	Product update(Product entity);

	void delete(String id);

	Product getMostExpensive();
}
