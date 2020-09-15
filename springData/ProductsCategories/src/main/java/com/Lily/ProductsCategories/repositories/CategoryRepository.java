package com.Lily.ProductsCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Lily.ProductsCategories.models.Category;
import com.Lily.ProductsCategories.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findAll();
	List<Category> findByProductsNotContains(Product product);
}