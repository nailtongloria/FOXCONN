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
import com.project.foxconn.model.Game;
import com.project.foxconn.repository.GameRepository;

@RestController
@RequestMapping(value="/api")
public class GameResource {
	@Autowired
	GameRepository dao;
	
	@PostMapping("/game")
	public ResponseEntity saveGame (@RequestBody Game game){
		dao.save(game);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("variavel", "adicionado com sucesso !!!");
		 return new ResponseEntity<>(game, responseHeaders, HttpStatus.OK);
		
	}
	
	@GetMapping("/game")
	public List<Game> listGame() {
		return dao.findAll();
	}
	@DeleteMapping("/game")
	public void deleteConsole(@RequestBody Game game) {
		dao.delete(game);
	}
	@PutMapping("/game")
	public Game updateConsole(@RequestBody Game game) {
		return dao.save(game);
	}


}
