package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="daycaremanager")
public class DaycareManager implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="Daycar_id")
	private Long id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private Date dateDispo;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="Kinder_id")
	private Kindergarten kindergarten;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Daycare_meet", joinColumns=
	{@JoinColumn(name="Daycar_id")},
			inverseJoinColumns= {@JoinColumn(name="Meet_id")
	})
	private List<Meeting> meeting = new ArrayList<>();

	public DaycareManager(Long id, String firstName, String lastName, Date dateDispo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateDispo = dateDispo;
	}
	public DaycareManager() {

	}

	
	
	
	
	public List<Meeting> getMeeting() {
		return meeting;
	}
	public void setMeeting(List<Meeting> meeting) {
		this.meeting = meeting;
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
	
	@Temporal(TemporalType.DATE)
	public Date getDateDispo() {
		return dateDispo;
	}
	public void setDateDispo(Date dateDispo) {
		this.dateDispo = dateDispo;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDispo == null) ? 0 : dateDispo.hashCode());
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
		DaycareManager other = (DaycareManager) obj;
		if (dateDispo == null) {
			if (other.dateDispo != null)
				return false;
		} else if (!dateDispo.equals(other.dateDispo))
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
		return "DaycareManager [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateDispo="
				+ dateDispo + ", getId()=" + getId() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getDateDispo()=" + getDateDispo() + ", hashCode()=" + hashCode() + "]";
	}
	
}
