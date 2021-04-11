package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="parent")
public class Parent implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_parent")
	private Long id;
	@Column
	private int phoneNumber;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String socialStatus;
	@Column
	private int kidsNumber;
	@Column
	private String email;
	@Column
	private String  password;
	@Column
	private String username;
	@Column
	private String registrationDate;
	@Column
	private Address address;
	private String photo;
	
	

	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@OneToMany(cascade= CascadeType.ALL,mappedBy="parent")
	private List<Post> post=new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="parent_satis", joinColumns=
	{@JoinColumn(name="id_parent")},
			inverseJoinColumns= {@JoinColumn(name="id_satisfaction")
	})
	private List<Satisfaction> satisfaction = new ArrayList<>();


	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="parent_child", joinColumns=
	{@JoinColumn(name="id_parent")},
			inverseJoinColumns= {@JoinColumn(name="child_id")
	})
	private List<Child> child = new ArrayList<>();

	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="id_admin")
	private Admin admin;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="parent_chat",joinColumns= {@JoinColumn(name="parent_fk")},
	inverseJoinColumns = {@JoinColumn(name ="chat_fk")})
	private Set<Chat> chat = new HashSet<>();
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="parent_reclamation",joinColumns= {@JoinColumn(name="parent_fk")},
	inverseJoinColumns = {@JoinColumn(name ="reclamation_fk")})
	private Set<Reclamation> reclamations = new HashSet<>();
	
	
	
	public Parent(Long id, int phoneNumber, String firstName, String lastName, String socialStatus, int kidsNumber,
			String email, String password, String username, String registrationDate, Address address ,String photo) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialStatus = socialStatus;
		this.kidsNumber = kidsNumber;
		this.email = email;
		this.password = password;
		this.username = username;
		this.registrationDate = registrationDate;
		this.address = address;
		this.photo =photo ;
	}
	
	
	public Parent() {
		
	}

	
	public Set<Reclamation> getReclamations() {
		return reclamations;
	}


	public void setReclamations(Set<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}


	public Set<Chat> getChat() {
		return chat;
	}


	public void setChat(Set<Chat> chat) {
		this.chat = chat;
	}


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Child> getChild() {
		return child;
	}


	public void setChild(List<Child> child) {
		this.child = child;
	}


	public List<Post> getPost() {
		return post;
	}


	public void setPost(List<Post> post) {
		this.post = post;
	}


	public List<Satisfaction> getSatisfaction() {
		return satisfaction;
	}


	public void setSatisfaction(List<Satisfaction> satisfaction) {
		this.satisfaction = satisfaction;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSocialStatus() {
		return socialStatus;
	}
	public void setSocialStatus(String socialStatus) {
		this.socialStatus = socialStatus;
	}
	public int getKidsNumber() {
		return kidsNumber;
	}
	public void setKidsNumber(int kidsNumber) {
		this.kidsNumber = kidsNumber;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + kidsNumber;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + phoneNumber;
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + ((socialStatus == null) ? 0 : socialStatus.hashCode());
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
		Parent other = (Parent) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
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
		if (kidsNumber != other.kidsNumber)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (socialStatus == null) {
			if (other.socialStatus != null)
				return false;
		} else if (!socialStatus.equals(other.socialStatus))
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
		return "Parent [id=" + id + ", phoneNumber=" + phoneNumber + ", firstName=" + firstName + ", lastName="
				+ lastName + ", socialStatus=" + socialStatus + ", kidsNumber=" + kidsNumber + ", email=" + email
				+ ", password=" + password + ", username=" + username + ", registrationDate=" + registrationDate
				+ ", address=" + address + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getUsername()=" + getUsername()
				+ ", getRegistrationDate()=" + getRegistrationDate() + ", getAddress()=" + getAddress() + ", getId()="
				+ getId() + ", getPhoneNumber()=" + getPhoneNumber() + ", getSocialStatus()=" + getSocialStatus()
				+ ", getKidsNumber()=" + getKidsNumber() + ", hashCode()=" + hashCode() + "]";
	}
	
}
	
	
	
	
	