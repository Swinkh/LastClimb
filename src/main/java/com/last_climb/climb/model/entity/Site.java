package com.last_climb.climb.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Site {

	private String name;

	@OneToMany(mappedBy = "site")
	private Set<Secteur> listSecteur = new HashSet<Secteur>();

	@OneToMany(mappedBy = "site")
	private Set<Commentaire> listCommentaire = new HashSet<Commentaire>();

	private String localisation;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int nbSect;

	public Site() {

	}

	public Site(String name, Set<Secteur> listSecteur, long id, String localisation) {
		super();
		this.name = name;
		this.listSecteur = listSecteur;
		this.id = id;
		this.nbSect = listSecteur.size();
		this.localisation = localisation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Secteur> getListSecteur() {
		return listSecteur;
	}

	public void setListSecteur(Set<Secteur> listSecteur) {
		this.listSecteur = new HashSet<Secteur>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void addSecteur(Secteur s) {
		this.listSecteur.add(s);
		this.nbSect++;
	}

	public void addCom(Commentaire c) {
		this.listCommentaire.add(c);
	}

	@Override
	public String toString() {
		return "Site [name=" + name + ", listSecteur=" + listSecteur + ", id=" + id + "]";
	}

	public int getNbSect() {
		return nbSect;
	}

	public void setNbSect(int nbSect) {
		this.nbSect = nbSect;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public Set<Commentaire> getListCommentaire() {
		return listCommentaire;
	}

	public void setListCommentaire(Set<Commentaire> listCommentaire) {
		this.listCommentaire = listCommentaire;
	}
}
