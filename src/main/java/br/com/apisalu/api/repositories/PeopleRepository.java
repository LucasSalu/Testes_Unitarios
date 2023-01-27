package br.com.apisalu.api.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apisalu.api.domain.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer>  {

	Optional<People> findByEmail(String email);



}
