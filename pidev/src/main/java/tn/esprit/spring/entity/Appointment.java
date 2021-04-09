package tn.esprit.spring.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="appointment")
public class Appointment implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Appointment_id")
	private Long id;
	@Column
	private Date date;
	@Column
	private Time time;
	@Column
	private String objectif;
	@Column
	private String parentName;
	@Column
	private String kindergartenName;
	
	
	
	
	public Appointment(Long id, Date date, Time time, String objectif, String parentName, String kindergartenName) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.objectif = objectif;
		this.parentName = parentName;
		this.kindergartenName = kindergartenName;
	}
	
	
	
	public Appointment() {
		
	}




	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Temporal(TemporalType.TIME)
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getKindergartenName() {
		return kindergartenName;
	}
	public void setKindergartenName(String kindergartenName) {
		this.kindergartenName = kindergartenName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kindergartenName == null) ? 0 : kindergartenName.hashCode());
		result = prime * result + ((objectif == null) ? 0 : objectif.hashCode());
		result = prime * result + ((parentName == null) ? 0 : parentName.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		Appointment other = (Appointment) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kindergartenName == null) {
			if (other.kindergartenName != null)
				return false;
		} else if (!kindergartenName.equals(other.kindergartenName))
			return false;
		if (objectif == null) {
			if (other.objectif != null)
				return false;
		} else if (!objectif.equals(other.objectif))
			return false;
		if (parentName == null) {
			if (other.parentName != null)
				return false;
		} else if (!parentName.equals(other.parentName))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", date=" + date + ", time=" + time + ", objectif=" + objectif
				+ ", parentName=" + parentName + ", kindergartenName=" + kindergartenName + ", getDate()=" + getDate()
				+ ", getTime()=" + getTime() + ", getObjectif()=" + getObjectif() + ", getParentName()="
				+ getParentName() + ", getKindergartenName()=" + getKindergartenName() + ", hashCode()=" + hashCode()
				+ "]";
	}
	

}
