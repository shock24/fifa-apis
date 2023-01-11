package com.iqnext.fifa.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//player_playing_time entity class
@Entity
@Table(name="player_playing_time")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerPlayingTime {
	
	@Id
	private Integer id;
	private String player;
	private String position;
	private String team;
	private String age;
	private Integer birth_year;
	private Integer games;
	private Integer minutes;
	private Integer minutes_per_game;
	private Double minutes_90s;
	private Double minutes_pct;
	private Integer game_starts;
	private Integer minutes_per_start;
	private Integer games_complete;
	private Integer games_subs;
	private Integer minutes_per_sub;
	private Integer unused_subs;
	private Double points_per_game;
	private Integer on_goals_for;
	private Integer on_goals_against;
	private Integer plus_minus;
	private Double plus_minus_per90;
	private Double plus_minus_wowy;
	private Double on_xg_for;
	private Double on_xg_against;
	private Double xg_plus_minus;
	private Double xg_plus_minus_per90;
	private Double xg_plus_minus_wowy;

}
