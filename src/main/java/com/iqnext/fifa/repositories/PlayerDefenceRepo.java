
package com.iqnext.fifa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iqnext.fifa.entities.PlayerDefence;
import com.iqnext.fifa.entities.PlayerStats;


//Repository for handling db operations related to player_defence table
public interface PlayerDefenceRepo extends JpaRepository<PlayerDefence, Integer> {
	List<PlayerDefence> findByPosition(String position);
	List<PlayerDefence> findByTeam(String team);
	List<PlayerDefence> findByTackles(Integer tackles);
}
