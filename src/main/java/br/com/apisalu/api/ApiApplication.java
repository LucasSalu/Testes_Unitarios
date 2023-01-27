package br.com.apisalu.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.apisalu.api.domain.People;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		
		People user =  new People(10, "salu", "sasda", "asdadsa");
	}

}
