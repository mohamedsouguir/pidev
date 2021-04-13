package tn.esprit.spring.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
@Table(name="Satis")
public class Satisfaction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_satisfaction")
	private Long id;
	@Column
	private Date date;
	@Column
	private String reponse;
	
	public Satisfaction(Long id, Date date, String reponse) {
		super();
		this.id = id;
		this.date = date;
		this.reponse = reponse;
	}
	public Satisfaction() {
	
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Size(max=500, message="Your response cannot exceed 150 characters")
	@NotEmpty(message="Your response cannot be empty")
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((reponse == null) ? 0 : reponse.hashCode());
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
		Satisfaction other = (Satisfaction) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (reponse == null) {
			if (other.reponse != null)
				return false;
		} else if (!reponse.equals(other.reponse))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Satisfaction [id=" + id + ", date=" + date + ", reponse=" + reponse + ", getId()=" + getId()
				+ ", getDate()=" + getDate() + ", getReponse()=" + getReponse() + ", hashCode()=" + hashCode() + "]";
	}


}
