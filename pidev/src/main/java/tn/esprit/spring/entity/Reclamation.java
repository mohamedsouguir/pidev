package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Reclamation")
public class Reclamation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_reclamation")
	private Long id;
	@Column
	private int nbReclamation;
	@Column
	private Date reclamationDate;
	@Column
	private String nomParent;
	@Column
	private String descreption;
	@Column
	private Date dateTraitement;
	@Column
	private String object;
	
	@ManyToMany(cascade= CascadeType.ALL,mappedBy="reclamations")
	private Set<Parent> parents = new HashSet<>();
	
	
	public Reclamation(Long id, int nbReclamation, Date reclamationDate, String nomParent, String descreption,
			Date dateTraitement, String object) {
		super();
		this.id = id;
		this.nbReclamation = nbReclamation;
		this.reclamationDate = reclamationDate;
		this.nomParent = nomParent;
		this.descreption = descreption;
		this.dateTraitement = dateTraitement;
		this.object = object;
	}
	
	public Reclamation() {
	}



	public Set<Parent> getParents() {
		return parents;
	}

	public void setParents(Set<Parent> parents) {
		this.parents = parents;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNbReclamation() {
		return nbReclamation;
	}
	public void setNbReclamation(int nbReclamation) {
		this.nbReclamation = nbReclamation;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getReclamationDate() {
		return reclamationDate;
	}
	public void setReclamationDate(Date reclamationDate) {
		this.reclamationDate = reclamationDate;
	}
	public String getNomParent() {
		return nomParent;
	}
	public void setNomParent(String nomParent) {
		this.nomParent = nomParent;
	}
	public String getDescreption() {
		return descreption;
	}
	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}
	@Temporal(TemporalType.DATE)
	public Date getDateTraitement() {
		return dateTraitement;
	}
	public void setDateTraitement(Date dateTraitement) {
		this.dateTraitement = dateTraitement;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	
	
	@Override
	public String toString() {
		return "Reclamation [id=" + id + ", nbReclamation=" + nbReclamation + ", reclamationDate=" + reclamationDate
				+ ", nomParent=" + nomParent + ", descreption=" + descreption + ", dateTraitement=" + dateTraitement
				+ ", object=" + object + ", getId()=" + getId() + ", getNbReclamation()=" + getNbReclamation()
				+ ", getReclamationDate()=" + getReclamationDate() + ", getNomParent()=" + getNomParent()
				+ ", getDescreption()=" + getDescreption() + ", getDateTraitement()=" + getDateTraitement()
				+ ", getObject()=" + getObject() + ", hashCode()=" + hashCode() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateTraitement == null) ? 0 : dateTraitement.hashCode());
		result = prime * result + ((descreption == null) ? 0 : descreption.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + nbReclamation;
		result = prime * result + ((nomParent == null) ? 0 : nomParent.hashCode());
		result = prime * result + ((object == null) ? 0 : object.hashCode());
		result = prime * result + ((reclamationDate == null) ? 0 : reclamationDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reclamation other = (Reclamation) obj;
		if (dateTraitement == null) {
			if (other.dateTraitement != null)
				return false;
		} else if (!dateTraitement.equals(other.dateTraitement))
			return false;
		if (descreption == null) {
			if (other.descreption != null)
				return false;
		} else if (!descreption.equals(other.descreption))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nbReclamation != other.nbReclamation)
			return false;
		if (nomParent == null) {
			if (other.nomParent != null)
				return false;
		} else if (!nomParent.equals(other.nomParent))
			return false;
		if (object == null) {
			if (other.object != null)
				return false;
		} else if (!object.equals(other.object))
			return false;
		if (reclamationDate == null) {
			if (other.reclamationDate != null)
				return false;
		} else if (!reclamationDate.equals(other.reclamationDate))
			return false;
		return true;
	}

}
