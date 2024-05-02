package com.estudo.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estudo.course.entities.User;
import com.estudo.course.services.UserService;

@RestController
@RequestMapping(value = "/users")  //Controlador rest que responde no caminho users
public class UserResources {

	@Autowired //Dependência feita pelo spring
	private UserService service;
	
	@GetMapping //get http
	public ResponseEntity<List<User>> findAll() { //Procurando todos os usuarios
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list); //.ok para voltar resposta com sucesso, .body para retornar corpo da resposta instanciado
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findyById(@PathVariable Long id) { //Procurando usuarios somente por id
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping //Anotação para inserir
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); //Criação variavel URI
		return ResponseEntity.created(uri).body(obj); //201 Created no postman
	}
	
	@DeleteMapping(value = "/{id}") //Anotação para deletar
	public ResponseEntity<Void> delete(@PathVariable Long id) { //PathVariable para o long id ser reconhecido como variavel url
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}") //Anotação para atualização
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
