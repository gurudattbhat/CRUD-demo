package com.h2test.service;

import com.h2test.domain.Author;
import com.h2test.domain.Post;
import com.h2test.dto.AuthorDto;
import com.h2test.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AuthorService implements UserDetailsService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private Author author;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Author author=authorRepository.findByUsername(username);
        if(author==null)
        {
            throw new UsernameNotFoundException("user not found with username"+username);
        }
        return new org.springframework.security.core.userdetails.User(author.getUsername(),author.getPassword(),new ArrayList<>());
    }


    public List<Author> read()
    {
        return authorRepository.findAll();

    }


    public Author findOne(long id)
    {
        return authorRepository.findAuthorById(id);
    }

    public Author save(AuthorDto author) {
        Author newAuthor = new Author();
        newAuthor.setUsername(author.getUsername());
        newAuthor.setId(author.getId());
        newAuthor.setPassword(bcryptEncoder.encode(author.getPassword()));
        return authorRepository.save(newAuthor);
    }

    public List<Post> getposts(long id){
        author=findOne(id);
        return author.getPosts();

    }
}