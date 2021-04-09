package tn.esprit.spring.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="admin")
public class Admin  implements Serializable  {
	

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id_admin")
		private Long id;
		@Column
		private int phoneNumber;
		@Column
		private String firstName;
		@Column
		private String lastName;
		@Column
		private String email;
		@Column
		private String login;
		
		

		@OneToMany(cascade= CascadeType.ALL,mappedBy="admin")
		private List<Parent> parent=new ArrayList<>();
		
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name="admin")
		private List<Reputation> reputation = new ArrayList<>();
		 
		public Admin(Long id, int phoneNumber, String firstName, String lastName, String email, String login) {
			super();
			this.id = id;
			this.phoneNumber = phoneNumber;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.login = login;
		}
		
		
		public Admin() {
			
		}
		
		
		public List<Reputation> getReputation() {
			return reputation;
		}


		public void setReputation(List<Reputation> reputation) {
			this.reputation = reputation;
		}


		public List<Parent> getParent() {
			return parent;
		}


		public void setParent(List<Parent> parent) {
			this.parent = parent;
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
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public int getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(int phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		
		
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((login == null) ? 0 : login.hashCode());
			result = prime * result + phoneNumber;
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
			Admin other = (Admin) obj;
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
			if (login == null) {
				if (other.login != null)
					return false;
			} else if (!login.equals(other.login))
				return false;
			if (phoneNumber != other.phoneNumber)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Admin [id=" + id + ", phoneNumber=" + phoneNumber + ", firstName=" + firstName + ", lastName="
					+ lastName + ", email=" + email + ", login=" + login + ", getId()=" + getId() + ", getFirstName()="
					+ getFirstName() + ", getLastName()=" + getLastName() + ", getEmail()=" + getEmail()
					+ ", getLogin()=" + getLogin() + ", getPhoneNumber()=" + getPhoneNumber() + ", hashCode()="
					+ hashCode() + "]";
		}
		
		
		
}
