package com.h2test.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Post {

	@Id
	private Long id;
	
	private String title;

	private String body;

	@Column(name = "posted_on")
	private Date postedOn;

	@ManyToOne
	@JoinColumn(name="author_id")
	private Author author;
	

	private Post(){}
	

	public Post(String title){
		this.setTitle(title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Post{" +
				"id=" + id +
				", title='" + title + '\'' +
				", body='" + body + '\'' +
				", postedOn=" + postedOn +
				", author=" + author +
				'}';
	}
}
