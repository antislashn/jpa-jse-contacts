package org.antislashn.contacts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "adresses")

@Entity
@Table(name="personnes")
public class Contact implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk")
	private long id;
	@Enumerated(EnumType.STRING)
	private Civilite civilite;
	private String nom;
	private String prenom;
	
	@ManyToOne
	@JoinTable(name = "contacts_adresses",
			joinColumns = @JoinColumn(name="fk_personne"),
			inverseJoinColumns = @JoinColumn(name = "fk_adresse"))
	private Adresse adresse;
	
	public Contact(Civilite civilite, String nom, String prenom) {
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
	
	
	
}
