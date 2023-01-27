package br.com.apisalu.api.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.apisalu.api.domain.dto.PeopleDTO;
import br.com.apisalu.api.services.PeopleService;

@RestController
@RequestMapping(value = "/user")
public class PeopleResource {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	PeopleService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PeopleDTO> findById(@PathVariable Integer id){
		
		return ResponseEntity.ok().body(mapper.map(service.findById(id), PeopleDTO.class));
		
	}
	
	@GetMapping
	public ResponseEntity<List<PeopleDTO>> findAll(){
		
		List<PeopleDTO> listDTO = service.findAll()
				.stream()
				.map(people -> mapper.map(people, PeopleDTO.class))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<PeopleDTO> create(@RequestBody PeopleDTO obj) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(service.create(obj).getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}

}
