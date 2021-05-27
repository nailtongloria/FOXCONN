package com.project.foxconn.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.foxconn.model.Console;
import com.project.foxconn.repository.ConsoleRepository;


@RestController
@RequestMapping(value="/api")
public class ConsoleResource {
	@Autowired
	ConsoleRepository dao;
	
	@PostMapping("/console")
	public ResponseEntity saveConsole (@RequestBody Console console){
		dao.save(console);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("variavel", "adicionado com sucesso !!!");
		 return new ResponseEntity<>(console, responseHeaders, HttpStatus.OK);
		
	}
	
	@GetMapping("/console")
	public List<Console> listConsole() {
		return dao.findAll();
	}
	@DeleteMapping("/console")
	public void deleteConsole(@RequestBody Console console) {
		dao.delete(console);
	}
	@PutMapping("/console")
	public Console updateConsole(@RequestBody Console console) {
		return dao.save(console);
	}

}
