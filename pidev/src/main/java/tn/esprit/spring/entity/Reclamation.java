package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	/*@Column
	private int nb_reclamation;*/

	private Date reclamation_date;
	@Column
	private String nomparent;
	@Column
	private String descreption;
	@Column
	
	private Date date_traitement;
	@Column
	private String object;
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	//public int getNb_reclamation() {
	//	return nb_reclamation;
	//}
	//public void setNb_reclamation(int nb_reclamation) {
		//this.nb_reclamation = nb_reclamation;
	//}
	
	@Temporal(TemporalType.DATE)
	public Date getReclamation_date() {
		return reclamation_date;
	}
	public void setReclamation_date(Date reclamation_date) {
		this.reclamation_date = reclamation_date;
	}
	public String getNomparent() {
		return nomparent;
	}
	public void setNomparent(String nomparent) {
		this.nomparent = nomparent;
	}
	public String getDescreption() {
		return descreption;
	}
	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}
	@Temporal(TemporalType.DATE)
	public Date getDate_traitement() {
		return date_traitement;
	}
	public void setDate_traitement(Date date_traitement) {
		this.date_traitement = date_traitement;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public Reclamation(Long id, int nb_reclamation, Date reclamation_date, String nomparent, String descreption,
			Date date_traitement, String object) {
		super();
		this.id = id;
		//this.nb_reclamation = nb_reclamation;
		this.reclamation_date = reclamation_date;
		//this.nomparent = nomparent;
		this.descreption = descreption;
		this.date_traitement = date_traitement;
		this.object = object;
	}
	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Reclamation [id=" + id +  ", reclamation_date=" + reclamation_date
				+ ", nomparent=" + nomparent + ", descreption=" + descreption + ", date_traitement=" + date_traitement
				+ ", object=" + object + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_traitement == null) ? 0 : date_traitement.hashCode());
		result = prime * result + ((descreption == null) ? 0 : descreption.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		//result = prime * result + nb_reclamation;
		result = prime * result + ((nomparent == null) ? 0 : nomparent.hashCode());
		result = prime * result + ((object == null) ? 0 : object.hashCode());
		result = prime * result + ((reclamation_date == null) ? 0 : reclamation_date.hashCode());
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
		if (date_traitement == null) {
			if (other.date_traitement != null)
				return false;
		} else if (!date_traitement.equals(other.date_traitement))
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
		//if (nb_reclamation != other.nb_reclamation)
			//return false;
		if (nomparent == null) {
			if (other.nomparent != null)
				return false;
		} else if (!nomparent.equals(other.nomparent))
			return false;
		if (object == null) {
			if (other.object != null)
				return false;
		} else if (!object.equals(other.object))
			return false;
		if (reclamation_date == null) {
			if (other.reclamation_date != null)
				return false;
		} else if (!reclamation_date.equals(other.reclamation_date))
			return false;
		return true;
	}

}
