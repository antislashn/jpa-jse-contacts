package org.antislashn.contacts;

import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class MainJpaContact {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contacts");
		ContactDao dao = new ContactDao(emf);
		
		Optional<Contact> opt = dao.findById(100);
		
		opt.ifPresent(System.out::println);

		Contact c1 = new Contact(Civilite.M,"Toto","Titi");
		dao.update(c1);
		System.out.println(c1);
		c1.setPrenom("François");
		dao.update(c1);
		System.out.println(c1);
		emf.close();

	}

}
