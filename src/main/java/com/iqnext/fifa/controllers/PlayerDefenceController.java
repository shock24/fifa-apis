package com.iqnext.fifa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iqnext.fifa.entities.PlayerDefence;
import com.iqnext.fifa.services.PlayerDefenceService;


/*
 * Player Defence Controller.
 * Controls/handles api request which require PlayerDefence data
 * */
@RestController
@RequestMapping("/fifa/api/v1/defense")
public class PlayerDefenceController {
	
	@Autowired
	private PlayerDefenceService playerDefenceService;
	
	
	//Api for fetching all players' defence data 
	@GetMapping("/get-all-details")
	public ResponseEntity<List<PlayerDefence>> getAllData()
	{
		List<PlayerDefence> allData = this.playerDefenceService.getAllData();
		return new ResponseEntity<>(allData, HttpStatus.OK);
	}
	
	
	//Api for fetching  all defence data of the player based upon the player id
	@GetMapping("/get-by-id/{id}")
	public ResponseEntity<PlayerDefence> getSingleData(@PathVariable Integer id)
	{
		PlayerDefence data = this.playerDefenceService.getSinglePlayerData(id);
		if(data!=null)
		{
			return new ResponseEntity<>(data, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
		
	}
	
	
	@GetMapping("/apply-filter/position/{position}")
	public ResponseEntity<List<PlayerDefence>> getAllDataByPosition(@PathVariable String position)
	{
		List<PlayerDefence> allData = this.playerDefenceService.getDataByPosition(position);
		return new ResponseEntity<>(allData, HttpStatus.OK);
	}
	
	
	@GetMapping("/apply-filter/team/{team}")
	public ResponseEntity<List<PlayerDefence>> getAllDataByTeam(@PathVariable String team)
	{
		List<PlayerDefence> allData = this.playerDefenceService.getDataByTeam(team);
		return new ResponseEntity<>(allData, HttpStatus.OK);
	}
	
	
	@GetMapping("/apply-filter/tackles/{tackles}")
	public ResponseEntity<List<PlayerDefence>> getAllDataByTackles(@PathVariable Integer tackles)
	{
		List<PlayerDefence> allData = this.playerDefenceService.getDataByTackles(tackles);
		return new ResponseEntity<>(allData, HttpStatus.OK);
	}

}
