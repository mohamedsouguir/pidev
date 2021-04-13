package tn.esprit.spring.dto;

import java.sql.Date;

import javax.persistence.Column;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.TypePost;

public class PostDto {
	private Long id;
	@Column
	private MultipartFile image;
	@Column
	private Date date;
	@Column
	private String description;
	@Column
	private MultipartFile video;
	@Column
	private TypePost type;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
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
	public MultipartFile getVideo() {
		return video;
	}
	public void setVideo(MultipartFile video) {
		this.video = video;
	}
	public TypePost getType() {
		return type;
	}
	public void setType(TypePost type) {
		this.type = type;
	}
	
}
