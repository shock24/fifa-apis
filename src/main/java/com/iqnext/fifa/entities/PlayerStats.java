package com.iqnext.fifa.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//player_stats entity class
@Entity
@Table(name="player_stats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerStats {
	
	@Id
	private Integer id;
	private String player;
	private String position;
	private String team;
	private String age;
	private String club;
	private Integer birth_year;
	private Integer games;
	private Integer games_starts;
	private Integer minutes;
	private Double minutes_90s;
	private Integer goals;
	private Integer assists;
	private Integer goals_pens;
	private Integer pens_made;
	private Integer pens_att;
	private Integer cards_yellow;
	private Integer cards_red;
	private Double goals_per90;
	private Double assists_per90;
	private Double goals_assists_per90;
	private Double goals_pens_per90;
	private Double goals_assists_pens_per90;
	private Double xg;
	private Double npxg;
	private Double xg_assist;
	private Double npxg_xg_assist;
	private Double xg_per90;
	private Double xg_assist_per90;
	private Double xg_xg_assist_per90;
	private Double npxg_per90;
	private Double npxg_xg_assist_per90;
	

}
