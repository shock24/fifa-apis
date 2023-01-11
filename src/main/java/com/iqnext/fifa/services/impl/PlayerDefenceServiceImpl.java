package com.iqnext.fifa.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqnext.fifa.entities.PlayerDefence;
import com.iqnext.fifa.repositories.PlayerDefenceRepo;
import com.iqnext.fifa.services.PlayerDefenceService;


//Implementation class for PlayerDefenceService interface
@Service
public class PlayerDefenceServiceImpl implements PlayerDefenceService {
	
	@Autowired
	private PlayerDefenceRepo playerDefenceRepo;

	
	//get all details of players
	@Override
	public List<PlayerDefence> getAllData() {
		List<PlayerDefence> allPlayerDefence = playerDefenceRepo.findAll();
		return allPlayerDefence;
	}
	
	
	//get details of particular player based on player id
	@Override
	public PlayerDefence getSinglePlayerData(Integer id) {
		PlayerDefence player = playerDefenceRepo.findById(id).orElse(null);
		return player;
	}


	//get details of all player based on player position
	@Override
	public List<PlayerDefence> getDataByPosition(String position) {
		List<PlayerDefence> allPlayerDefence = playerDefenceRepo.findByPosition(position);
		return allPlayerDefence;
	}


	//get details of all player based on player team
	@Override
	public List<PlayerDefence> getDataByTeam(String team) {
		List<PlayerDefence> allPlayerDefence = playerDefenceRepo.findByTeam(team);
		return allPlayerDefence;
	}

	

	//get details of all player based on player tackles
	@Override
	public List<PlayerDefence> getDataByTackles(Integer tackles) {
		List<PlayerDefence> allPlayerDefence = playerDefenceRepo.findByTackles(tackles);
		return allPlayerDefence;
	}
	
	

}
