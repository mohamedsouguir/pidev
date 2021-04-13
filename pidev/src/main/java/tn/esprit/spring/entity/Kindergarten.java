package tn.esprit.spring.entity;

import java.beans.Transient;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;


@Entity
@Table(name="kindergarten")
public class Kindergarten implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="Kinder_id")
	private Long id;
	@Column
	private String description;
	@Column
	private String logo;
	@Column
	private Date creationDate;
	@Column
	private int EmployeNumber;
	@Column
	@NotNull
	private int phone;
	@Column
	@NotBlank(message = "firstname is mandatory")
	private String firstName;
	@Column
	@NotBlank(message = "lastname is mandatory")
	private String lastName;
	@Column
	@Email
	private String email;
	@Column
	private String  password;
	@Column
	private String username;
	@Column
	private String registrationDate;
	@Column
	private Address address;
	@Column
	private int cost;
	@Column(nullable = true, length = 64)
	private String photos;
	
	 @Transient
	    public String getPhotosImagePath() {
	        if (photos == null || id == null) return null;
	         
	        return "/user-photos/" + id + "/" + photos;
	    }
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="kinder_director", joinColumns=
	{@JoinColumn(name="Kinder_id")},
			inverseJoinColumns= {@JoinColumn(name="director_id")
	})
	private Director director;
	
	
	@OneToMany(cascade= CascadeType.ALL,mappedBy="kindergarten")
	private List<DaycareManager> daycareManagers=new ArrayList<>();
	
	

	@OneToMany(cascade= CascadeType.ALL,mappedBy="kindergarten")
	private List<BusDriver> busdriver=new ArrayList<>();
	
	@OneToMany(cascade= CascadeType.ALL,mappedBy="kindergarten")
	private List<Post> post=new ArrayList<>();
	

	@OneToMany(cascade= CascadeType.ALL,mappedBy="kindergarten")
	private List<Doctor> doctor=new ArrayList<>();
	

	@OneToMany(cascade= CascadeType.ALL,mappedBy="kindergarten")
	private List<Notif> notif=new ArrayList<>();
	
	
	public Kindergarten(Long id, String description, String logo, Date creationDate, int employeNumber, int phone,
			String firstName, String lastName, String email, String password, String username, String registrationDate,
			Address address, int cost, String photos) {
		super();
		this.id = id;
		this.description = description;
		this.logo = logo;
		this.creationDate = creationDate;
		EmployeNumber = employeNumber;
		this.phone = phone;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.username = username;
		this.registrationDate = registrationDate;
		this.address = address;
		this.cost = cost;
		this.photos = photos;
	}
	


	public Kindergarten() {
	
	}

	

	
	
	public List<BusDriver> getBusdriver() {
		return busdriver;
	}



	public void setBusdriver(List<BusDriver> busdriver) {
		this.busdriver = busdriver;
	}



	public List<Doctor> getDoctor() {
		return doctor;
	}



	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}



	public List<Notif> getNotif() {
		return notif;
	}



	public void setNotif(List<Notif> notif) {
		this.notif = notif;
	}



	public List<DaycareManager> getDaycareManagers() {
		return daycareManagers;
	}



	public void setDaycareManagers(List<DaycareManager> daycareManagers) {
		this.daycareManagers = daycareManagers;
	}



	public Director getDirector() {
		return director;
	}



	public void setDirector(Director director) {
		this.director = director;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	@Temporal(TemporalType.DATE)
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getEmployeNumber() {
		return EmployeNumber;
	}
	public void setEmployeNumber(int employeNumber) {
		EmployeNumber = employeNumber;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	@Embedded
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + EmployeNumber;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + cost;
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + phone;
		result = prime * result + ((photos == null) ? 0 : photos.hashCode());
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Kindergarten other = (Kindergarten) obj;
		if (EmployeNumber != other.EmployeNumber)
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cost != other.cost)
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		if (logo == null) {
			if (other.logo != null)
				return false;
		} else if (!logo.equals(other.logo))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone != other.phone)
			return false;
		if (photos == null) {
			if (other.photos != null)
				return false;
		} else if (!photos.equals(other.photos))
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Kindergarten [id=" + id + ", description=" + description + ", logo=" + logo + ", creationDate="
				+ creationDate + ", EmployeNumber=" + EmployeNumber + ", phone=" + phone + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", username=" + username
				+ ", registrationDate=" + registrationDate + ", address=" + address + ", cost=" + cost + ", photos="
				+ photos + ", getId()=" + getId() + ", getDescription()=" + getDescription() + ", getLogo()="
				+ getLogo() + ", getPhotos()=" + getPhotos() + ", getCreationDate()=" + getCreationDate()
				+ ", getEmployeNumber()=" + getEmployeNumber() + ", getPhone()=" + getPhone() + ", getFirstName()="
				+ getFirstName() + ", getLastName()=" + getLastName() + ", getEmail()=" + getEmail()
				+ ", getPassword()=" + getPassword() + ", getUsername()=" + getUsername() + ", getRegistration_date()="
				+ getRegistrationDate() + ", getAddress()=" + getAddress() + ", getCost()=" + getCost()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	
}
	
	
	
	
	
	