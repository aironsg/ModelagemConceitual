package com.dev.airon.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.airon.cursomc.domain.Client;
import com.dev.airon.cursomc.exceptions.ObjectNotFoundException;
import com.dev.airon.cursomc.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository repo;
	
	public Client findClient(Long id) {
		Optional<Client> objClient = repo.findById(id);
		
		return objClient.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()));
	}

}
