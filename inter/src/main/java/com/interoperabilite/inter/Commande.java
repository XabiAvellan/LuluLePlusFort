package com.interoperabilite.inter;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "commande")
public class Commande {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal id;
	
	private Date dateCommande;
	private String nomEmmeteur;

	public Commande() {
		super();
	}
	public Commande(BigDecimal id, Date dateCommande) {
		super();
		this.id = id;
		this.dateCommande = dateCommande;
	}

	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}

	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	
	public String getNomEmmeteur() {
		return nomEmmeteur;
	}
	public void setNomEmmeteur(String nomEmmeteur) {
		this.nomEmmeteur = nomEmmeteur;
	}
}
