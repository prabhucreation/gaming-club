package com.prabu.project2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prabu.project2.entities.Game;
import com.prabu.project2.services.GameService;


@RestController
@RequestMapping("/games")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@PostMapping("/save")
	public Game save(@RequestBody Game game) {
		return gameService.saveGame(game);
	}
	
	@GetMapping("/all")
	public List<Game> getGames(){
		return gameService.findGame();
	}
	
	@GetMapping("/{id}")
	public Game get(@PathVariable int id) {
		return gameService.findGame(id);
	}
	
	@PutMapping("/update/{id}")
	public Game update(@PathVariable int id,@RequestBody Game game) {
		return gameService.updateGame(id, game);
	}
	
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable int id) {
		return gameService.deleteGame(id);
	}
}
