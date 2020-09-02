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
		Adresse a = contact.getAdresse();
		if (a != null) {
			if (a.getId() == 0) {
				em.persist(a);
			} else {
				em.merge(a);
			}
		}
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

	public void saveOrUpdate(Contact c) {
		if (c != null) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			if (c.getId() == 0) {
				em.persist(c);
			} else {
				em.merge(c);
			}
			em.getTransaction().commit();
			em.close();
		}
	}

	public void delete(Contact contact) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Contact c = em.find(Contact.class, contact.getId());
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}

	public List<Contact> findByCivilite(Civilite civilite) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT c FROM Contact c WHERE c.civlite = :civilite";
		List<Contact> contacts = em.createQuery(query, Contact.class).setParameter("civilite", civilite)
				.getResultList();
		em.close();
		return contacts;
	}

}
