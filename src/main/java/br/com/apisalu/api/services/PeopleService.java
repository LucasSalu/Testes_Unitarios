package br.com.apisalu.api.services;

import java.util.List;

import br.com.apisalu.api.domain.People;
import br.com.apisalu.api.domain.dto.PeopleDTO;

public interface PeopleService {
	
	People findById(Integer id);

	List<People> findAll();
	
	People create(PeopleDTO obj);
}
