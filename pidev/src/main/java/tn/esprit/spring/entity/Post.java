package tn.esprit.spring.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="post")
public class Post implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Post_id")
	private Long id;
	@Lob
	@Column
	private byte[] image;
	@Column
	private Date date;
	@Column
	private String description;
	@Lob
	@Column
	private byte[] video;
	@Column
	private TypePost type;
	

	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="Kinder_id")
	private Kindergarten kindergarten;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="id_parent")
	private Parent parent;
	
	@OneToMany(cascade= CascadeType.ALL,mappedBy="post")
	private List<Comment> comment=new ArrayList<>();

	
	public Post(Long id, byte[] image, Date date, String description, byte[] video, TypePost type) {
		super();
		this.id = id;
		this.image = image;
		this.date = date;
		this.description = description;
		this.video = video;
		this.type = type;
	}
		public Post() {
		
	}
	
		
	public Post(byte[] image, Date date, String description, byte[] video) {
			super();
			this.image = image;
			this.date = date;
			this.description = description;
			this.video = video;
		}
	
	
	
	
	public Post(Long id, byte[] image, Date date, String description, byte[] video) {
		super();
		this.id = id;
		this.image = image;
		this.date = date;
		this.description = description;
		this.video = video;
	}
	public Parent getParent() {
			return parent;
		}
		public void setParent(Parent parent) {
			this.parent = parent;
		}
	public List<Comment> getComment() {
			return comment;
		}
		public void setComment(List<Comment> comment) {
			this.comment = comment;
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
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getVideo() {
		return video;
	}
	public void setVideo(byte[] video) {
		this.video = video;
	}
	

	@Enumerated(EnumType.STRING)
	public TypePost getType() {
		return type;
	}
	public void setType(TypePost type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Post [image=" + image + ", date=" + date + ", description=" + description + ", video=" + video
				+ ", type=" + type + ", getImage()=" + getImage() + ", getDate()=" + getDate() + ", getDescription()="
				+ getDescription() + ", getVideo()=" + getVideo() + ", getType()=" + getType() + "]";
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((video == null) ? 0 : video.hashCode());
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
		Post other = (Post) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (type != other.type)
			return false;
		if (video == null) {
			if (other.video != null)
				return false;
		} else if (!video.equals(other.video))
			return false;
		return true;
	}

}


