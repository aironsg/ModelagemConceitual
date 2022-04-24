package com.dev.airon.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev.airon.cursomc.domain.Category;
import com.dev.airon.cursomc.domain.City;
import com.dev.airon.cursomc.domain.Product;
import com.dev.airon.cursomc.domain.State;
import com.dev.airon.cursomc.repositories.CategoryRepository;
import com.dev.airon.cursomc.repositories.CityRepository;
import com.dev.airon.cursomc.repositories.ProductRepository;
import com.dev.airon.cursomc.repositories.StateRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
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
		
		State state1 = new State("Minas Gerais");
		State state2 = new State("São Paulo");
		
		City city1 = new City("Uberlândia", state1);
		City city2 = new City("São Paulo", state2);
		City city3 = new City("Campinas", state2);
		
		
		category1.getProducts().addAll(Arrays.asList(product1,product2,product3));
		category2.getProducts().addAll(Arrays.asList(product2));
		
		product1.getCategorys().addAll(Arrays.asList(category1));
		product2.getCategorys().addAll(Arrays.asList(category1,category2));
		product3.getCategorys().addAll(Arrays.asList(category1));
		
		
		
		state1.getCitys().addAll(Arrays.asList(city1));
		state2.getCitys().addAll(Arrays.asList(city2,city3));
		
		categoryRepository.saveAll(Arrays.asList(category1, category2,category3));
		productRepository.saveAll(Arrays.asList(product1,product2,product3));
		stateRepository.saveAll(Arrays.asList(state1,state2));
		cityRepository.saveAll(Arrays.asList(city1,city2, city3));
	}

}
