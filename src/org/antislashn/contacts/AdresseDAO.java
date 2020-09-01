package org.antislashn.contacts;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AdresseDAO {
	private EntityManagerFactory emf;

	public AdresseDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public Optional<Adresse> findById(int id){
		EntityManager em = emf.createEntityManager();
		Adresse a = em.find(Adresse.class, id);
		em.close();
		return Optional.ofNullable(a);
	}

}
