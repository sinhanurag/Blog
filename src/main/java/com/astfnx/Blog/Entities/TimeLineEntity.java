package com.astfnx.Blog.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="blogentries")

public class TimeLineEntity {
	@Id
	@Column(name="postID")
	int postId;
	
	@Column(name="title")
	String title;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	Date date;
	
	public String getTitle() {
		return title;
	}

	public Date getDate() {
		return date;
	}
	
	public int getPostId() {
		return postId;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	public void setPostId(int postId) {
		this.postId = postId;
	}

	
	

}
