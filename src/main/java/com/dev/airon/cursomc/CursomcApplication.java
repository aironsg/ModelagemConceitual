package com.dev.airon.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.dev.airon.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev.airon.cursomc.domain.Anddress;
import com.dev.airon.cursomc.domain.Category;
import com.dev.airon.cursomc.domain.City;
import com.dev.airon.cursomc.domain.Client;
import com.dev.airon.cursomc.domain.Payment;
import com.dev.airon.cursomc.domain.PaymentByCard;
import com.dev.airon.cursomc.domain.PaymentWithTicket;
import com.dev.airon.cursomc.domain.Product;
import com.dev.airon.cursomc.domain.Request;
import com.dev.airon.cursomc.domain.State;
import com.dev.airon.cursomc.domain.enums.PaymentStatus;
import com.dev.airon.cursomc.domain.enums.TypeClient;

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
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AnddressRepository anddressRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private RequestRepository requestRepository;
	
	
	
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
		
		Client client1 = new Client("Joao santana", "joao@teste.com", "000.111.222-33", TypeClient.PESSOAFISICA);
		client1.getPhones().addAll(Arrays.asList("9-9494-2525", "9-9235-4518"));
		
		
		Anddress anddress1 = new Anddress("rua qualquer", "jardim oliveira", "22", "apt_C", "55000-012", client1, city1);
		Anddress anddress2 = new Anddress("lapaz", "macapuana", "300", "sala 02", "55045-254", client1, city2);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Request request1 = new Request(dateFormat.parse("30/09/2021 10:32"), anddress1, client1);
		Request request2 = new Request(dateFormat.parse("25/04/2022 00:00"), anddress2, client1);
		
		Payment payment1 = new PaymentByCard(PaymentStatus.QUITADO,request1, 6);
		request1.setPayment(payment1);
		
		Payment payment2 = new PaymentWithTicket(PaymentStatus.PENDENTE, request2, dateFormat.parse("20/04/2022 00:000"), null);
		request2.setPayment(payment2);
		
		//adicionar os objs nos repositorys.
		//não fiz por questão de tempo.
		//hahahahaha
		
		
		
		category1.getProducts().addAll(Arrays.asList(product1,product2,product3));
		category2.getProducts().addAll(Arrays.asList(product2));
		
		product1.getCategorys().addAll(Arrays.asList(category1));
		product2.getCategorys().addAll(Arrays.asList(category1,category2));
		product3.getCategorys().addAll(Arrays.asList(category1));
			
		
		state1.getCitys().addAll(Arrays.asList(city1));
		state2.getCitys().addAll(Arrays.asList(city2,city3));
		
		client1.getAnddress().addAll(Arrays.asList(anddress1,anddress2));
		client1.getRequests().addAll(Arrays.asList(request1,request2));
		
		categoryRepository.saveAll(Arrays.asList(category1, category2,category3));
		productRepository.saveAll(Arrays.asList(product1,product2,product3));
		stateRepository.saveAll(Arrays.asList(state1,state2));
		cityRepository.saveAll(Arrays.asList(city1,city2, city3));
		clientRepository.saveAll(Arrays.asList(client1));
		anddressRepository.saveAll(Arrays.asList(anddress1,anddress2));
		requestRepository.saveAll(Arrays.asList(request1, request2));
		paymentRepository.saveAll(Arrays.asList(payment1,payment2));
		
	}

}
