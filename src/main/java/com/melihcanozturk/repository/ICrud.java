package com.melihcanozturk.repository;

import java.util.List;

import org.hibernate.Session;

import com.melihcanozturk.util.HibernateUtils;

public interface ICrud<T> {

	void save(T t);					// save işlemi void
	
	void update(T t,long id);		// güncelleme işlemi void
	
	T findById(long id);			// id'ye göre nesne çekeceğimiz için bize nesne dönecek.
	
	void delete(long id);			// silme işlemi boş döneceği için void.
	
	List<T> findAll();				// Tüm bilgileri bulacağımız için bize bir liste dönecek..	
	
	// bilgileri almak için repository katmanının database'ye erişim sağlaması gerekiyor. bu neden varsayılan bir oturum döndürmemiz gerekli..
	
	default Session databaseConnectionHibernate() {
		return HibernateUtils.getSessionFactory().openSession();
		
		
	}
}
