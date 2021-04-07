package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="busdriver")
public class BusDriver implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Bus_id")
	private Long id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private Date dateDispo;
	@Column
	private int NumBus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="bus_path", joinColumns=
	{@JoinColumn(name="Bus_id")},
			inverseJoinColumns= {@JoinColumn(name="Path_id")
	})
	private Path path;
	

	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="Kinder_id")
	private Kindergarten kindergarten;
	

	
	
	public BusDriver(Long id, String firstName, String lastName, Date dateDispo, int numBus) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateDispo = dateDispo;
		NumBus = numBus;
	}
	
	
	
	public BusDriver(Long id, String firstName, String lastName, Date dateDispo, int numBus, Path path,
			Kindergarten kindergarten) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateDispo = dateDispo;
		NumBus = numBus;
		this.path = path;
		this.kindergarten = kindergarten;
	}



	public BusDriver() {

	}
	
	
	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
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
	public int getNumBus() {
		return NumBus;
	}
	public void setNumBus(int numBus) {
		NumBus = numBus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + NumBus;
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
		BusDriver other = (BusDriver) obj;
		if (NumBus != other.NumBus)
			return false;
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
		return "BusDriver [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateDispo="
				+ dateDispo + ", NumBus=" + NumBus + ", getId()=" + getId() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getDateDispo()=" + getDateDispo() + ", getNumBus()="
				+ getNumBus() + ", hashCode()=" + hashCode() + "]";
	}
	
}
