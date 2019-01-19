package org.Sokoba.tpjavaee.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name="Maire")
@Table( name="maires")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Maire implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlAttribute
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
	@XmlElement
    @Column(name="civilite")
    @Enumerated(EnumType.STRING)
	private Civility civilite;
    
	@XmlElement
    @Column(name="nom")
	private String nom;
    
	@XmlElement
    @Column(name="prenom")
	private String prenom;
    
	@XmlElement
    @Column(name="dateDeNaissance")
    @Temporal(TemporalType.DATE)
	private Date  dateDeNaissance;
    
    /*@OneToOne(mappedBy="maire")*/  
	@XmlElement
    @JoinColumn(name="commune")
    private Commune commune ;
    


	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Civility getCivilite() {
		return civilite;
	}

	public void setCivilite(Civility civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Maire(Civility civilite, String nom, String prenom, Date dateDeNaissance) {
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
	}

	public Maire() {
	}

	@Override
	public String toString() {
		return "Maire [id=" + id + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateDeNaissance=" + dateDeNaissance + "]";
	}
    
    
}
