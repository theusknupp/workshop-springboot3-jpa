package com.estudo.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.course.entities.Order;
import com.estudo.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")  //Controlador rest que responde no caminho orders
public class OrderResource {

	@Autowired //Dependência feita pelo spring
	private OrderService service;
	
	@GetMapping //get http
	public ResponseEntity<List<Order>> findAll() { //Procurando todos os usuarios
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list); //.ok para voltar resposta com sucesso, .body para retornar corpo da resposta instanciado
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findyById(@PathVariable Long id) { //Procurando usuarios somente por id
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
