package org.antislashn.contacts;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class MainJpaContact {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contacts");
		ContactDao dao = new ContactDao(emf);
		Adresse a = new Adresse("rue de la mer", "35400", "Saint-Malo");
		Contact c1 = new Contact(Civilite.M, "Leroux", "Gaston");
		Contact c2 = new Contact(Civilite.Mme, "Blanc-Sec", "Adèle");
		c1.setAdresse(a);
		c2.setAdresse(a);
		
		dao.save(c1);
		dao.save(c2);
		emf.close();
	}

}
