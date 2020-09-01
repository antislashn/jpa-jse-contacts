package org.antislashn.contacts;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ContactDao {
	private EntityManagerFactory emf;

	public ContactDao(EntityManagerFactory emf) {
		this.emf = emf;
	};

	public Optional<Contact> findById(long id) {
		EntityManager em = emf.createEntityManager();
		Contact contact = em.find(Contact.class, id);
		em.close();
		return Optional.ofNullable(contact);
	}
	
	public void update(Contact contact) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(contact);
		em.getTransaction().commit();
		em.close();		
	}

	public void save(Contact contact) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(contact);
		em.getTransaction().commit();
		em.close();
	}

	public void save(Optional<Contact> opt) {
		if (opt.isPresent()) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(opt.get());
			em.getTransaction().commit();
			em.close();
		}
	}

}
