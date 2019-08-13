package com.ba.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory;
	private static EntityManager entityManager;
	
	public static EntityManager getEntityManager() {
		factory = Persistence.createEntityManagerFactory("JPA-PU");
		entityManager = factory.createEntityManager();
		return entityManager;
	}
}