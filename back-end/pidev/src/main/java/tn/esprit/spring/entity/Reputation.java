package tn.esprit.spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Reputation")
public class Reputation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reputation")
	private Long id;
	@Column
	int numStar;
	@Column
	int numbrSat;
	
	
	
	public Reputation(Long id, int numStar, int numbrSat) {
		super();
		this.id = id;
		this.numStar = numStar;
		this.numbrSat = numbrSat;
	}


	public Reputation() {
		
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumStar() {
		return numStar;
	}
	public void setNum_star(int numStar) {
		this.numStar = numStar;
	}
	public int getNumbrSat() {
		return numbrSat;
	}
	public void setNumbrSat(int numbrSat) {
		this.numbrSat = numbrSat;
	}


	@Override
	public String toString() {
		return "Reputation [id=" + id + ", numStar=" + numStar + ", numbrSat=" + numbrSat + ", getId()=" + getId()
				+ ", getNumStar()=" + getNumStar() + ", getNumbrSat()=" + getNumbrSat() + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + numStar;
		result = prime * result + numbrSat;
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
		Reputation other = (Reputation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numStar != other.numStar)
			return false;
		if (numbrSat != other.numbrSat)
			return false;
		return true;
	}
	
	

	

}
