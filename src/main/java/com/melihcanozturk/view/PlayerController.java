package com.melihcanozturk.view;

import com.melihcanozturk.entity.Player;
import com.melihcanozturk.entity.Team;
import com.melihcanozturk.entity.enums.ECountry;
import com.melihcanozturk.repository.PlayerDao;

public class PlayerController {

	public static void main(String[] args) {
		

		PlayerDao playerDao = new PlayerDao();
		//Player player = new Player();
		playerDao.findById(3);
		Team team = new Team("WAS");
		Player player = new Player("Nicolas Batum",team,33,ECountry.FRA);
		
//		Player player2 = new Player("Grayson Allen","MIL",12,"USA");
//		Player player3 = new Player("Jarrett Alvarado","NOP",15,"USA");
//		Player player4 = new Player("Kyle Anderson","MIN",5,"USA");
//		Player player5 = new Player("Giannis Antetokounmpo","MIL",34,"Greece");
//		Player player6 = new Player("O.G. Anunoby","TOR",3,"United Kingdom");
//		Player player7 = new Player("Rui Hachimura","WAS",6,"Japan");
//		Player player8 = new Player("Furkan Korkmaz","PHI",30,"Turkey");
	//playerDao.save(player);
//		playerDao.save(player2);
//		playerDao.save(player3);
//		playerDao.save(player4);
//		playerDao.save(player5);
//		playerDao.save(player6);
//		playerDao.save(player7);
//		playerDao.save(player8);
	//	playerDao.update(player, 11);
	//	playerDao.delete(14);
		
	}

}
