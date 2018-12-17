package br.sham.web.banco.api.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JPAUtil {
	
	private static EntityManagerFactory emf;
	
	public static EntityManager getEntityManager() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("banco");
		}
		return emf.createEntityManager();
	}

}
