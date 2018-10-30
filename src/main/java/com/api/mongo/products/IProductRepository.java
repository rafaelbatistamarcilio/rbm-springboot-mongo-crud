package com.api.mongo.products;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductRepository extends MongoRepository<Product, String>{

    public Product findByDescription(String description);
}
