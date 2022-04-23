package com.dev.airon.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.airon.cursomc.domain.Category;
import com.dev.airon.cursomc.services.CategoryService;

@RestController
@RequestMapping(value="/categorias")
public class CategoryResource {
	
	@Autowired
	CategoryService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id){
		Category objCategory = service.findCategory(id);
		return ResponseEntity.ok().body(objCategory);
	}
	
	
	
	

}
