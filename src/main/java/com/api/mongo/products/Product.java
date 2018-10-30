package com.api.mongo.products;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.api.mongo.core.IEntity;

@Document(collection="products")
public class Product implements IEntity{

	@Id
    private String _id;

    
    private String description;

    private BigDecimal price;

    private String photo;

    @Override
    public String getId() {
        return this._id;
    }

	public void setId(String _id) {
		this._id = _id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
