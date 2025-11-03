package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeGlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<EmployeeErrorModel>handelException(EmployeeNotFoundException ex){
	EmployeeErrorModel model=new EmployeeErrorModel (HttpStatus.NOT_FOUND.value(),ex.getMessage());
		return new ResponseEntity<>(model,HttpStatus.NOT_FOUND);
	}
}
