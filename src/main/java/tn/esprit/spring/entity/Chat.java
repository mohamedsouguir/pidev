package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;




@Entity
@Table(name="chat")
public class Chat implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_chat")
	private Long id;
	@Column
	private String content;
	@Column
	private String sender;
	@Column
	private MessageType type;
	
	@ManyToMany(cascade= CascadeType.ALL,mappedBy="chat")
	private Set<Parent> parents = new HashSet<>();

	
	
	public Chat(Long id, String content, String sender, MessageType type) {
		super();
		this.id = id;
		this.content = content;
		this.sender = sender;
		this.type = type;
	}




	public Chat() {
	
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getContent() {
		return content;
	}




	public void setContent(String content) {
		this.content = content;
	}




	public String getSender() {
		return sender;
	}




	public void setSender(String sender) {
		this.sender = sender;
	}




	@Enumerated(EnumType.STRING)
	public MessageType getType() {
		return type;
	}




	public void setType(MessageType type) {
		this.type = type;
	}




	public Set<Parent> getParents() {
		return parents;
	}

	public void setParents(Set<Parent> parents) {
		this.parents = parents;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Chat other = (Chat) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		if (type != other.type)
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "Chat [id=" + id + ", content=" + content + ", sender=" + sender + ", type=" + type + ", getId()="
				+ getId() + ", getContent()=" + getContent() + ", getSender()=" + getSender() + ", getType()="
				+ getType() + ", getParents()=" + getParents() + ", hashCode()=" + hashCode() + "]";
	}

}
