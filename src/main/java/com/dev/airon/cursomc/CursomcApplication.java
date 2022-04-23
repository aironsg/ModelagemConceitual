package com.dev.airon.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev.airon.cursomc.domain.Category;
import com.dev.airon.cursomc.domain.Product;
import com.dev.airon.cursomc.repositories.CategoryRepository;
import com.dev.airon.cursomc.repositories.ProductRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		

		//Dados testes, para a aplicação
		Category category1 = new Category("Informática");
		Category category2 = new Category("Escritório");
		Category category3 = new Category("Eletronicos");
		
		Product product1 = new Product("Computador", 5000.00);
		Product product2 = new Product("Impressora", 800.00);
		Product product3 = new Product("Mouse", 80.00);
		
		category1.getProducts().addAll(Arrays.asList(product1,product2,product3));
		category2.getProducts().addAll(Arrays.asList(product2));
		
		product1.getCategorys().addAll(Arrays.asList(category1));
		product2.getCategorys().addAll(Arrays.asList(category1,category2));
		product3.getCategorys().addAll(Arrays.asList(category1));
		
		categoryRepository.saveAll(Arrays.asList(category1, category2,category3));
		productRepository.saveAll(Arrays.asList(product1,product2,product3));
	}

}
