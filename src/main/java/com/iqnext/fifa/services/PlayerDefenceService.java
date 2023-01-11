package com.iqnext.fifa.services;

import java.util.List;

import com.iqnext.fifa.entities.PlayerDefence;

public interface PlayerDefenceService {
	
	//get all defense data
	List<PlayerDefence> getAllData();
	
	//get single player defense data
	PlayerDefence getSinglePlayerData(Integer id);
	
	
	List<PlayerDefence> getDataByPosition(String position);
	
	List<PlayerDefence> getDataByTeam(String team);
	
	List<PlayerDefence> getDataByTackles(Integer tackles);
	

}
