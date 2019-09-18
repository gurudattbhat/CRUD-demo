package com.h2test.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.persistence.*;

@Component
@Entity
public class Author {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//private String firstName;
	//private String lastName;
	private String username;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;


	@OneToMany( mappedBy = "author" )
	@JsonIgnore
	private List<Post> posts;


	public Author(){ }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
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


	@Override
	public String toString() {
		return "Author{" +
				"id=" + id +
				", username='" + username + '\'' +
				", posts=" + posts +
				'}';
	}
}
