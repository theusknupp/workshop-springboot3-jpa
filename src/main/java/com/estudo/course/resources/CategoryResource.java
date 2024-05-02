package com.estudo.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.course.entities.Category;
import com.estudo.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")  //Controlador rest que responde no caminho users
public class CategoryResource {

	@Autowired //Dependência feita pelo spring
	private CategoryService service;
	
	@GetMapping //get http
	public ResponseEntity<List<Category>> findAll() { //Procurando todos os usuarios
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list); //.ok para voltar resposta com sucesso, .body para retornar corpo da resposta instanciado
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findyById(@PathVariable Long id) { //Procurando usuarios somente por id
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
