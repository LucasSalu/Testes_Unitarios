package br.com.apisalu.api.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.apisalu.api.domain.People;
import br.com.apisalu.api.repositories.PeopleRepository;

@Configuration
@Profile("local")
public class LocalConfig {
	
		@Autowired
		private PeopleRepository repository;

		@Bean
		public void startDB() {
			People u1 = new People(null,"Valdir","valdir@mail.com","123");
			People u2 = new People(null,"Luiz","luiz@mail.com","123");

			repository.saveAll(List.of(u1,u2));
		}
}
