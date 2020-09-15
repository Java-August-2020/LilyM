package com.Lily.ProductsCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Lily.ProductsCategories.models.Category;
import com.Lily.ProductsCategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);
}
