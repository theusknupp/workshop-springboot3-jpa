package com.estudo.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.course.entities.User;

@RestController
@RequestMapping(value = "/users")  //Controlador rest que responde no caminho users
public class UserResources {

	@GetMapping //get http
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "Maria@gmail.com", "993131", "12345");
		return ResponseEntity.ok().body(u); //.ok para voltar resposta com sucesso, .body para retornar corpo da resposta instanciado
	}
	
}
