package tn.esprit.spring.entity;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="visitor")
public class Visitor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_visitor")
	private Long id;
	
	private String firstName;
	
	private String lastName;

	private String email;
	
	private String  password;
	
	private String username;
	
	private String registrationDate;
	
	private Address address;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Reputation> reputation = new HashSet<>();
	
	public Visitor(Long id, String firstName, String lastName, String email, String password, String username,
			String registrationDate, Address address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.username = username;
		this.registrationDate = registrationDate;
		this.address = address;
	}
	public Visitor() {
	}
	
	
	public Set<Reputation> getReputation() {
		return reputation;
	}
	public void setReputation(Set<Reputation> reputation) {
		this.reputation = reputation;
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
	
	@Override
	public String toString() {
		return "Visitor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", username=" + username + ", registrationDate=" + registrationDate
				+ ", address=" + address + ", getId()=" + getId() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
				+ ", getUsername()=" + getUsername() + ", getRegistrationDate()=" + getRegistrationDate()
				+ ", getAddress()=" + getAddress() + "]";
	}
	
}
	
	
	
	
	
	