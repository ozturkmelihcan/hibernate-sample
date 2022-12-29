package com.melihcanozturk.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.melihcanozturk.entity.Player;

public class PlayerDao implements ICrud<Player> {

	@Override
	public void save(Player t) {
		Transaction transaction = null;
		try (Session session = databaseConnectionHibernate()) {
			transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println("Saved Error");
		}

	}

	@Override
	public void update(Player t, long id) {
		Session session = null;
		try {
			Player player = findById(id);
			if (player != null) {
				player.setNameSurname(t.getNameSurname());
				player.setNumber(t.getNumber());
				player.setCountry(t.getCountry());
				player.setTeam(t.getTeam());
				session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(player);
				session.getTransaction().commit();
				System.out.println("Oyuncu Bilgileri Güncellendi...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	@Override
	public Player findById(long id) {
		Session session = databaseConnectionHibernate();
		Player player;
		try {
			player = session.load(Player.class, id);
			if (player != null) {
				System.out.println("Oyuncu bulundu---> " + player);
				return player;
			} else {
				System.out.println("Lütfen ID'yi kontrol ediniz...");
			}
		} catch (Exception e) {
			System.out.println("Birşeyler ters gitti...");
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void delete(long id) {
		Transaction transaction = null;
		try (Session session = databaseConnectionHibernate()) {
			Player player = findById(id);
			if (player != null) {
				transaction = session.beginTransaction();
				session.delete(player);
				session.getTransaction().commit();
				System.out.println("Oyuncu silindi..." + player.getNameSurname());
			} else {
				System.err.println("ID'yi kontrol edin");
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	@Override
	public List<Player> findAll() {
		Transaction transaction = null;
		List<Player> playerList = null;
		try (Session session = databaseConnectionHibernate()) {
			transaction = session.beginTransaction();
			playerList = session.createQuery("from Player", Player.class).list();
			transaction.commit();
			for (Player player : playerList) {
				System.out.println(player);
			}
		}
		return playerList;
	}

}
