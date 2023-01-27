package br.com.apisalu.api.services.exceptions;

public class JdbcSQLIntegrityConstraintViolationException extends RuntimeException {

	public JdbcSQLIntegrityConstraintViolationException(String message) {
		super(message);
	}

	
}
