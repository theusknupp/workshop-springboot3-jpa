package com.estudo.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.course.entities.Order;
import com.estudo.course.repositories.OrderRepository;

@Service //Registra a classe como componente, permitindo a dependência feita pelo spring com o autowired
public class OrderService {
	
	@Autowired //Dependência feita pelo spring
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}

}
