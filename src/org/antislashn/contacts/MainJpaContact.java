package org.antislashn.contacts;

import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class MainJpaContact {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contacts");
		ContactDao dao = new ContactDao(emf);
		AdresseDAO adresseDao = new AdresseDAO(emf);
		
		Optional<Contact> opt = dao.findById(2);
		
		opt.ifPresent(System.out::println);
		
		Contact c1 = new Contact(Civilite.Pr, "Foo", "Jean");
		Adresse a1 = new Adresse("rue de la Soif", "35000", "Rennes");
		c1.setAdresse(a1);
		dao.save(c1);
		
		Optional<Adresse> opt2 = adresseDao.findById(1);
		opt2.ifPresent(System.out::println);

		emf.close();
	}

}
