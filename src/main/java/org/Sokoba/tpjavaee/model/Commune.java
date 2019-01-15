package org.Sokoba.tpjavaee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name="Commune")
@Table(name="communes")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Commune implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlAttribute
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@XmlElement
	@Column(name="nom_commune")
	private String nom;
	
	/*@XmlElement
	@Column(name="code_postal")
	private String codePostal;*/
	
	public Commune() {
		
	}
	public Commune(long id,String nom) {
		this.id=id;
		this.nom=nom;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setId(long id) {
		this.id = id;
	}
		
	public long getId() {
		return this.id;
	}

}
