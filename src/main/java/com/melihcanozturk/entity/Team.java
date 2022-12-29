package com.melihcanozturk.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Team {

	private String team;

	
	public Team() {
		
	}

	public Team(String team) {
		super();
		this.team = team;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Team [team=" + team + "]";
	}
	
	
	
}
