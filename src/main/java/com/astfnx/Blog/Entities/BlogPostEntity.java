package com.astfnx.Blog.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="blogentries")
public class BlogPostEntity {
	
	@Id
	@Column(name="postID")
	@GeneratedValue
	int postId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	Date date;
	
	@Column(name="location")
	String location;
	
	@Column(name="textcontent")
	String content;
	
	@Column(name="title")
	String title;

	public int getPostId() {
		return postId;
	}

	public Date getDate() {
		return date;
	}

	public String getLocation() {
		return location;
	}

	public String getContent() {
		return content;
	}

	public String getTitle() {
		return title;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
