package com.iqnext.fifa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iqnext.fifa.entities.PlayerStats;
import com.iqnext.fifa.services.PlayerStatsService;

/*
 * Player Stats Controller.
 * Controls/handles api request which require PlayerStats data
 * */


@RestController
@RequestMapping("fifa/api/v1/statistics")
public class PlayerStatsController {
	
	@Autowired
	private PlayerStatsService playerStatsService;
	
	
	//Api for fetching all players' statistics data 
	@GetMapping("/get-all-details")
	public ResponseEntity<List<PlayerStats>> getAllData()
	{
		List<PlayerStats> allData = this.playerStatsService.getAllDetails();
		return new ResponseEntity<>(allData, HttpStatus.OK);
	}
	
	
	//Api for fetching  all statistical data of the player based upon the player id
	@GetMapping("/get-by-id/{id}")
	public ResponseEntity<PlayerStats> getSingleData(@PathVariable Integer id)
	{
		PlayerStats data = this.playerStatsService.getPlayerStats(id);
		if(data!=null)
		{
			return new ResponseEntity<>(data, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}
	
	//Api for fetching  all statistical data of all the player based upon the player's birthyear
	@GetMapping("/apply-filter/birth-year/{birthYear}")
	public ResponseEntity<List<PlayerStats>> getPlayersByBirthYear(@PathVariable Integer birthYear)
	{
		List<PlayerStats> data = this.playerStatsService.getPlayerByBirthYear(birthYear);
		if(data!=null)
		{
			return new ResponseEntity<>(data, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}
	
	//Api for fetching  all statistical data of all the player based upon the player's games played
	@GetMapping("/apply-filter/games/{games}")
	public ResponseEntity<List<PlayerStats>> getPlayersByGames(@PathVariable Integer games)
	{
		List<PlayerStats> data = this.playerStatsService.getPlayerByGames(games);
		if(data!=null)
		{
			return new ResponseEntity<>(data, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}
	
	
	//Api for fetching  all statistical data of all the player based upon the player's number of goals
	@GetMapping("/apply-filter/goals/{goals}")
	public ResponseEntity<List<PlayerStats>> getPlayersByGoals(@PathVariable Integer goals)
	{
		List<PlayerStats> data = this.playerStatsService.getPlayerByGoals(goals);
		if(data!=null)
		{
			return new ResponseEntity<>(data, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}
	
	

}
