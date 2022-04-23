package com.dev.airon.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.airon.cursomc.domain.Category;
import com.dev.airon.cursomc.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository repo;
	
	public Category findCategory(Long id) {
		Optional<Category> objCategory = repo.findById(id);
		
		return objCategory.orElse(null);
	}

}
