package com.Lily.ProductsCategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Lily.ProductsCategories.models.Category;
import com.Lily.ProductsCategories.models.Product;
import com.Lily.ProductsCategories.repositories.CategoryRepository;
import com.Lily.ProductsCategories.repositories.ProductRepository;

@Service
public class ManyToManyService {
	private  ProductRepository pRepo;
	private  CategoryRepository cRepo;
	
	//constructor
	public ManyToManyService(ProductRepository pRepo, CategoryRepository cRepo) {
		this.pRepo = pRepo;
		this.cRepo = cRepo;
	}
	//FindAll
	public List<Product> findProducts() {
		return this.pRepo.findAll();
	}
		public List<Category> findCategories() {
		return this.cRepo.findAll();
	}
	//FindById
	public Product getProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	public Category getCategory(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	//Create
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}
	public Category createCategory(Category  category) {
		return this.cRepo.save(category);
	}
	//FindByxxxNotContains
	public List<Category> findCategoriesNotInProduct(Product product) {
		return cRepo.findByProductsNotContains(product);
	}
	public List<Product> findProductsNotInCategory(Category category) {
		return pRepo.findByCategoriesNotContains(category);
	}
}