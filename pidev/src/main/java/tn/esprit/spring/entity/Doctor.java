package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="doctor")
public class Doctor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="Doctor_id")
	private Long id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	@Enumerated(EnumType.STRING)
	private Jour JourDispo;
	


	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="Kinder_id")
	private Kindergarten kindergarten;
	
	@OneToMany(cascade = CascadeType.ALL)
	
	
	private Set<Appointment> appointments ;
	
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy="d")
	
	private List<Appointment> a;*/
	
	
	


	public Doctor(Long id, String firstName, String lastName, Jour jourDispo,
			Kindergarten kindergarten, Set<Appointment> appointment) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		JourDispo = jourDispo;
		this.kindergarten = kindergarten;
		this.appointments = appointment;
	}

	
	public Set<Appointment> getAppointments() {
		return appointments;
	}


	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}


	public Doctor() {
	
	}



	


	public Kindergarten getKindergarten() {
		return kindergarten;
	}


	public void setKindergarten(Kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Jour getJourDispo() {
		return JourDispo;
	}
	public void setJourDispo(Jour JourDispo) {
		this.JourDispo = JourDispo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((JourDispo == null) ? 0 : JourDispo.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Doctor other = (Doctor) obj;
		if (JourDispo == null) {
			if (other.JourDispo != null)
				return false;
		} else if (!JourDispo.equals(other.JourDispo))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", JourDispo=" + JourDispo
				+ ", getId()=" + getId() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getJourDispo()=" + getJourDispo() + ", hashCode()=" + hashCode() + "]";
	}
	
}
