package com.iqnext.fifa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqnext.fifa.entities.PlayerStats;
import com.iqnext.fifa.repositories.PlayerStatsRepo;
import com.iqnext.fifa.services.PlayerStatsService;


//Implementation class for PlayerStatsService interface
@Service
public class PlayerStatsServiceImpl implements PlayerStatsService {
	
	@Autowired
	private PlayerStatsRepo playerStatsRepo;

	
	//get all details of players
	@Override
	public List<PlayerStats> getAllDetails() {
		List<PlayerStats> allStats = this.playerStatsRepo.findAll();
		return allStats;
	}

	
	//get details of particular player based on player id
	@Override
	public PlayerStats getPlayerStats(Integer id) {
		PlayerStats player = this.playerStatsRepo.findById(id).orElse(null);
		return player;
	}

	//get details of particular player based on player birth_year
	@Override
	public List<PlayerStats> getPlayerByBirthYear(Integer birth_year) {
		List<PlayerStats> allPlayers = this.playerStatsRepo.findByBirthYear(birth_year);
		return allPlayers;
	}

	//get details of particular player based on player games played
	@Override
	public List<PlayerStats> getPlayerByGames(Integer games) {
		List<PlayerStats> allPlayers = this.playerStatsRepo.findByGames(games);
		return allPlayers;
	}


	//get details of particular player based on player's goals
	@Override
	public List<PlayerStats> getPlayerByGoals(Integer goals) {
		List<PlayerStats> allPlayers = this.playerStatsRepo.findByGoals(goals);
		return allPlayers;
	}
	

}
