//package com.h2test.service;
//
//import javax.annotation.PostConstruct;
//
//import com.h2test.domain.Author;
//import com.h2test.repository.AuthorRepository;
//import com.h2test.repository.PostRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.h2test.domain.Post;
//
//@Service
//public class DataLoader {
//
//	private PostRepository postRepository;
//	private AuthorRepository authorRepository;
//
//	@Autowired
//	public DataLoader(PostRepository postRepository,AuthorRepository authorRepository){
//		this.postRepository = postRepository;
//		this.authorRepository = authorRepository;
//	}
//
//	@PostConstruct
//	private void loadData(){
//		// create an author
//		Author dv = new Author("guru","bhat");
//		authorRepository.save(dv);
//
//		// create a post
//		Post post = new Post("Spring Data Rocks!");
//		post.setBody("Post Body...");
//		post.setAuthor(dv);
//		postRepository.save(post);
//	}
//
//}
