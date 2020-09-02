package org.antislashn.contacts;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class ContactDto {
	private long id;
	private Civilite civilite;
	private String nom;
	private String prenom;
}
