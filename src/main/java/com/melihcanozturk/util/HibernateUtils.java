package com.melihcanozturk.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.melihcanozturk.entity.Player;

public class HibernateUtils {
	
	
	private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

	private static SessionFactory sessionFactoryHibernate() {			// Configuration ayarlarımızı bu metodun içinde ve try-catch blokları arasında 
																		// yapıyoruz.
		try {
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Player.class);
			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			return factory;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
	
	
}
