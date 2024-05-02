package com.estudo.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudo.course.entities.User;
import com.estudo.course.repositories.UserRepository;

@Configuration // Classe especifíca de configuração
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired // Dependência
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception { // Executa tudo que estiver dentro do metodo

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2)); //Passa uma lista de objetos para ser salva no banco de dados.

	}

}
