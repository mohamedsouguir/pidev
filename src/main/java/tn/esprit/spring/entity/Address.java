package tn.esprit.spring.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String rue;
	private String ville;
	
	
	
	
	public Address(String rue, String ville) {
		super();
		this.rue = rue;
		this.ville = ville;
	}
	public Address() {
	}
	
	
	
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rue == null) ? 0 : rue.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
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
		Address other = (Address) obj;
		if (rue == null) {
			if (other.rue != null)
				return false;
		} else if (!rue.equals(other.rue))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Address [rue=" + rue + ", ville=" + ville + ", getRue()=" + getRue() + ", getVille()=" + getVille()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	
	
}
