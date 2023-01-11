package com.iqnext.fifa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iqnext.fifa.entities.PlayerStats;

//Repository for handling database operations related to player_stats table
public interface PlayerStatsRepo extends JpaRepository<PlayerStats, Integer> {
	@Query("Select p from PlayerStats p where p.birth_year = :year")
	List<PlayerStats> findByBirthYear(@Param("year") Integer birthYear);
	
	List<PlayerStats> findByGames(Integer games);
	
	List<PlayerStats> findByGoals(Integer goals);
}
