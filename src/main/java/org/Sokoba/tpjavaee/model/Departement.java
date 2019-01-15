package org.Sokoba.tpjavaee.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name="Departement")
@Table(	name="departements")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Departement implements Serializable {


	@XmlAttribute
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@XmlElement
	@Column(name="nom_departement")
	private String nom;

	@XmlElement
	@Column(name="code_departement")
	private String code;

	/*@OneToMany(mappedBy="departement",fetch=FetchType.LAZY)
	private Set<Commune> Communes = new HashSet<Commune>();*/

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Departement() {
	}

	/*@Override
	public String toString() {
		return "Departement [id=" + id + ", nom=" + nom + ", code=" + code + ", Communes=" + Communes + "]";
	}	*/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Departement [id=" + id + ", nom=" + nom + ", code=" + code + "]";
	}	


	//	public int getNumberOfTown() {
	//
	//		Query query=entityManager.createNativeQuery( "SELECT commune FROM Commune commune where departement_id = this.code");
	//		List<Commune> communes = query.getResultList();
	//		for (Object c : communes) {
	//			// chaque �l�ment est de type NameBean
	//			Commune commune = (Commune)c ;
	//			this.Communes.add(commune) ;
	//		}		
	//		return this.Communes.size();
	//	}

}
