package com.iqnext.fifa.services;

import java.util.List;

import com.iqnext.fifa.entities.PlayerStats;

public interface PlayerStatsService {
	
	//get all player statistics data
	List<PlayerStats> getAllDetails();
	
	//get single player stats
	PlayerStats getPlayerStats(Integer id);
	
	//get all player statistics data on basis of birth_year
	List<PlayerStats> getPlayerByBirthYear(Integer birth_year);
	
	//get all player statistics data on basis of games played
	List<PlayerStats> getPlayerByGames(Integer games);
	
	//get all player statistics data on basis of goals scored
	List<PlayerStats> getPlayerByGoals(Integer goals);

}
