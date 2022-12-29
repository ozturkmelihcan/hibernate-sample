package com.melihcanozturk.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.melihcanozturk.entity.enums.ECountry;

@Entity
@Table(name="nba_table")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(nullable=false)
	private String nameSurname;
	
	@Embedded
	private Team team;
	
	private int number;
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private ECountry country;
	
	
	public Player() {
		
	}


	public Player(long id, String nameSurname, Team team, int number, ECountry country) {
		super();
		this.id = id;
		this.nameSurname = nameSurname;
		this.team = team;
		this.number = number;
		this.country = country;
	}


	public Player(String nameSurname, Team team, int number, ECountry country) {
		super();
		this.nameSurname = nameSurname;
		this.team = team;
		this.number = number;
		this.country = country;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNameSurname() {
		return nameSurname;
	}


	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}


	public Team getTeam() {
		return team;
	}


	public void setTeam(Team team) {
		this.team = team;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public ECountry getCountry() {
		return country;
	}


	public void setCountry(ECountry country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "Player [id=" + id + ", nameSurname=" + nameSurname + ", team=" + team + ", number=" + number
				+ ", country=" + country + "]";
	}
	
	
	
	
}
