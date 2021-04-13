package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tarif")
public class Tarif implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_Tarif")
	private Long id;
	@Column
	private static final double prixfixe=1500;
	@Column
	private double nouveauTarif;
	public double getNouveauTarif() {
		return nouveauTarif;
	}


	public void setNouveauTarif(double nouveauTarif) {
		this.nouveauTarif = nouveauTarif;
	}


	@Column
	static final double prixPourcentage = 0.2;
  
	
     
    
    public Tarif() {
	
	}


	public Tarif(Long id, double prixfixe) {
		super();
		this.id = id;
			
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	


	public static double getPrixpourcentage() {
		return prixPourcentage;
	}

	public double getPrixfixe() {
		return prixfixe;
	}
	




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prixfixe);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Tarif other = (Tarif) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(prixfixe) != Double.doubleToLongBits(other.prixfixe))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Tarif [id=" + id + ", prixfixe=" + prixfixe + ", getId()=" + getId() + ", getPrixfixe()="
				+ getPrixfixe() + ", hashCode()=" + hashCode() + "]";
	}


}
