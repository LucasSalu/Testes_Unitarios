package br.com.apisalu.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apisalu.api.domain.People;
import br.com.apisalu.api.domain.dto.PeopleDTO;
import br.com.apisalu.api.repositories.PeopleRepository;
import br.com.apisalu.api.services.PeopleService;
import br.com.apisalu.api.services.exceptions.JdbcSQLIntegrityConstraintViolationException;
import br.com.apisalu.api.services.exceptions.ObjectNotFoundException;

@Service
public class PeopleServiceImpl implements PeopleService {
	
	@Autowired
	private PeopleRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public People findById(Integer id) {
		Optional<People> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(("Objeto não encontrado")));
		
	}
	
	public List<People> findAll(){
		List<People> people = repository.findAll();
		return people;
	}

	@Override
	public People create(PeopleDTO obj) {
		this.findByEmail(obj);
		return repository.save(mapper.map(obj, People.class));
	}
	
	private void findByEmail(PeopleDTO obj) {
		Optional<People> people = repository.findByEmail(obj.getEmail());
		if(people.isPresent()) {
			throw new JdbcSQLIntegrityConstraintViolationException("Email Ja Cadastrado no sistema");
		}
	}
	
	

}
