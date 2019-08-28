package com.h2test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class H2demoApplication {
	

	
    public static void main(String[] args)
	{
        SpringApplication.run(H2demoApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(AuthorRepository authorRepository, PostRepository postRepository) {
//        return args -> {
//
//            Author dv = new Author("Krishna","raju");
//            authorRepository.save( dv );
//
//            Post post = new Post("Spring Boot Rocks!");
//
//            post.setBody("Post Body");
//            post.setPostedOn(new Date());
//            post.setAuthor(dv);
//            postRepository.save(post);
//
//            Post rest = new Post("REST is what all the cool kids are doing");
//
//            rest.setBody("REST BODY");
//            rest.setPostedOn(new Date());
//            rest.setAuthor(dv);
//            postRepository.save(rest);
//
//        };
//    }
}
