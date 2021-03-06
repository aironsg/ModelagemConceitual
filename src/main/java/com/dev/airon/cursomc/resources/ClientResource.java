package com.dev.airon.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.airon.cursomc.domain.Client;
import com.dev.airon.cursomc.services.ClientService;

@RestController
@RequestMapping(value = "/clientes")
public class ClientResource {
	
	@Autowired
	ClientService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id){
		Client objClient = service.findClient(id);
		return ResponseEntity.ok().body(objClient);
	}

}
