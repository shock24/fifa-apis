package com.iqnext.fifa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iqnext.fifa.entities.PlayerPlayingTime;


//Repository for handling db operations related to player_playing_time table
public interface PlayerPlayingTimeRepo extends JpaRepository<PlayerPlayingTime, Integer> {

}
