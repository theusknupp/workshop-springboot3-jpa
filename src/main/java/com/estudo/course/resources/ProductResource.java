package com.estudo.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.course.entities.Product;
import com.estudo.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")  //Controlador rest que responde no caminho products
public class ProductResource {

	@Autowired //Dependência feita pelo spring
	private ProductService service;
	
	@GetMapping //get http
	public ResponseEntity<List<Product>> findAll() { //Procurando todos os usuarios
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list); //.ok para voltar resposta com sucesso, .body para retornar corpo da resposta instanciado
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findyById(@PathVariable Long id) { //Procurando usuarios somente por id
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
