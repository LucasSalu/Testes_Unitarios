package br.com.apisalu.api.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PeopleDTO {
	
	private Integer id;
	private String name;
	private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

}
